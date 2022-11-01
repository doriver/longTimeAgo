package com.web.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.exercise.dao.StatusDAO;

@Controller
public class StatusController {

	@Autowired
	private StatusDAO statusDAO;
	
	@GetMapping("/alive") // 통과
	@ResponseBody
	public int updateell(@RequestParam("name") String name) {
		
//		return statusDAO.updateStatus(name, true);
		return statusDAO.updateStatus(name, false);
	}
}
