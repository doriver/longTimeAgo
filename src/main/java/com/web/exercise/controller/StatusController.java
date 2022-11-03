package com.web.exercise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.exercise.bo.StatusBO;
import com.web.exercise.dao.StatusDAO;
import com.web.exercise.model.AliveStatus;

@RestController
public class StatusController {

	@Autowired
	private StatusDAO statusDAO;
	
	@Autowired
	private StatusBO statusBO;
	
	// alive 상태 체크
	@PatchMapping("/statuses/{name}")
	public Map<String,Boolean> checkAlive(@PathVariable("name") String name) {
		
		Map<String,Boolean> result = new HashMap<>();
		
		if (statusBO.aliveCheck(name) == 1) {
			result.put("aliveCheck", true);
			return result;
		} else {
			result.put("aliveCheck", false);
			return result;
		}
	}
	
	// 한 호스트 alive모니터링 결과 조회
	@GetMapping("/statuses/{name}") 
	public AliveStatus oneMonitor(@PathVariable("name") String name) {
		
		checkAlive(name);
		
		return statusDAO.selectStatus(name);
	}
	
	// 전체 호스트 alive모니터링 결과 조회
	@GetMapping("/statuses")
	public List<AliveStatus> fullMonitor() {
		
		return statusBO.makeList();
	}
}
