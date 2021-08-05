package com.sleep.spring.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
