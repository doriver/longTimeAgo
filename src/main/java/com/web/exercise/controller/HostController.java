package com.web.exercise.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.exercise.dao.HostDAO;
import com.web.exercise.dao.StatusDAO;
import com.web.exercise.model.HostInfo;

@Controller
public class HostController {

	@Autowired
	private HostDAO hostDAO;
	
	@Autowired
	private StatusDAO statusDAO;
	
	@GetMapping("/insert") // 통과
	@ResponseBody
	public int inserttt(
			@RequestParam("name") String name
			, @RequestParam("ip") String ip) {
		
		statusDAO.insertStatus(name);
		
		return hostDAO.insertHost(name, ip);
	}
	
	@GetMapping("/select") // 통과
	@ResponseBody
	public HostInfo selecttt(@RequestParam("name") String name) {
		return hostDAO.selectHost(name);
	}
	
	@GetMapping("/update") // 통과
	@ResponseBody
	public int updateee(@RequestParam("name") String name
			, @RequestParam("ip") String ip) {
		return hostDAO.updateHost(name, ip);
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public int deleteee(@RequestParam("name") String name) {
		return hostDAO.deleteHost(name);
	}
}
