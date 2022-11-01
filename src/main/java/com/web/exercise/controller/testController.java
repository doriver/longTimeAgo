package com.web.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.exercise.dao.testDAO;

@RestController
public class testController {
	@Autowired
	private testDAO test;
	
	@RequestMapping("/name")
	public List<String> nameList() {
		return test.selectName();
	} // 작동함
}
