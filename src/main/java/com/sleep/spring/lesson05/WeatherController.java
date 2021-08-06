package com.sleep.spring.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sleep.spring.lesson05.bo.WeatherBO;
import com.sleep.spring.lesson05.model.Weather;

@RequestMapping("/lesson05/test05")
@Controller
public class WeatherController {
	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/weather_info")
	public String getWeatherInfo(Model model) {
		
		List<Weather> weather = weatherBO.getWeather();
				
		model.addAttribute("weather", weather);
				
		return "lesson05/weatherInfo";
	}
	
	@GetMapping("/add_weather_view")
	public String addWeatherView() {
		return "lesson05/addWeather";
	}
	
	@PostMapping("/add_weather")
	public String addWeather(
			@RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed) {
		
		weatherBO.addWeather(weather, temperatures, precipitation, microDust, windSpeed);
		
		return "redirect:/lesson05/test05/weather_info";
	}
}
