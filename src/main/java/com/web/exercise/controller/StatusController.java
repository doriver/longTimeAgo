package com.web.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.exercise.bo.StatusBO;
import com.web.exercise.dao.StatusDAO;
import com.web.exercise.model.AliveStatus;

@Controller
public class StatusController {

	@Autowired
	private StatusDAO statusDAO;
	
	@Autowired
	private StatusBO statusBO;
	
	@GetMapping("/alive") 
	@ResponseBody
	public void updateell(@RequestParam("name") String name) {
		
		statusBO.aliveCheck(name);
//		return statusDAO.updateStatus(name, true);
//		return statusDAO.updateStatus(name, false);
	}
	
	@GetMapping("/monitor") 
	@ResponseBody
	public AliveStatus oneMonitor(@RequestParam("name") String name) {
		
		updateell(name);
		
		return statusDAO.selectStatus(name);
	}
	
	@GetMapping("/fullmonitor") 
	@ResponseBody
	public List<AliveStatus> fullMonitor() {
		
		return ;
	}
}
