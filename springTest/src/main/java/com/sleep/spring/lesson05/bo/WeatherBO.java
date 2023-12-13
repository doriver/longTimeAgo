package com.sleep.spring.lesson05.bo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleep.spring.lesson05.dao.WeatherDAO;
import com.sleep.spring.lesson05.model.Weather;

@Service
public class WeatherBO {
	@Autowired
	private WeatherDAO weatherDAO;
	
	public List<Weather> getWeather() {
		return weatherDAO.selectWeather();
	}
	
	public int addWeather(String weather, double temperatures, double precipitation, String microDust, double windSpeed) {
		return weatherDAO.insertWeather(weather, temperatures, precipitation, microDust, windSpeed);
	}
}
