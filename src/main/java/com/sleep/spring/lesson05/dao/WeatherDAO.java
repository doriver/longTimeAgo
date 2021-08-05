package com.sleep.spring.lesson05.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sleep.spring.lesson05.model.Weather;

@Repository
public interface WeatherDAO {
	public List<Weather> selectWeather();
}
