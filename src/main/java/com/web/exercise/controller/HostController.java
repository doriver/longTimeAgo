package com.web.exercise.controller;
import java.util.ArrayList;
import java.util.List;
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
	public String inserttt(
			@RequestParam("name") String name
			, @RequestParam("ip") String ip) {
		
		if (hostDAO.insertHost(name, ip) == 1) {
			
			statusDAO.insertStatus(name);
			return "정상적으로 등록 됐습니다";
			
		} else {
			return "등록 실패";
		}

	}
	
	@GetMapping("/select") // 통과
	@ResponseBody
	public HostInfo selecttt(@RequestParam("name") String name) {
		return hostDAO.selectHost(name);
	}
	
	@GetMapping("/update") // 통과
	@ResponseBody
	public String updateee(
			@RequestParam("name") String name
			, @RequestParam("ip") String ip) {
		
		if (hostDAO.updateHost(name, ip) == 1) {
			return name + "의 ip가 변경되었습니다";
		} else {
			return "ip변경 실패";
		}
		
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteee(@RequestParam("name") String name) {
		
		if (hostDAO.deleteHost(name) == 1) {
			
			statusDAO.deleteStatus(name);
			return "정상적으로 삭제 됐습니다";
			
		} else {
			return "삭제 실패";
		}
		
	}
}
