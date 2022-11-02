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
	public String updateell(@RequestParam("name") String name) {
		
		if (statusBO.aliveCheck(name) == 1) {
			return "alive상태 조회 완료";
		} else {
			return "alive상태 조회 실패";
		}
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
		
		return statusBO.makeList();
	}
}
