package com.web.exercise.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface testDAO {
	public List<String> selectName(); 
}
