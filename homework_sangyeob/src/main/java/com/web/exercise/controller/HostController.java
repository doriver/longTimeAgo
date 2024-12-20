package com.web.exercise.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.web.exercise.dao.HostDAO;
import com.web.exercise.dao.StatusDAO;
import com.web.exercise.model.HostInfo;

@RestController
public class HostController {

	@Autowired
	private HostDAO hostDAO;
	
	@Autowired
	private StatusDAO statusDAO;
	
	// 호스트 등록
	@PostMapping("/hosts")
	public Map<String,String> hostRegistration (
			@RequestParam("name") String name
			, @RequestParam("ip") String ip) throws Exception {
		
		Map<String,String> result = new HashMap<>();
		
		if (hostDAO.countHost() >= 100) {
			result.put("registration", "close");
			return result;
		} 

		int z = 0;
		try {

			z = hostDAO.insertHost(name, ip);

			if (z == 1) {
				
				statusDAO.insertStatus(name);
				
				result.put("registration", "success");
				return result;
				
			} else {
				result.put("registration", "failure");
				return result;
			}
			
		} catch (Exception e) {

			e.printStackTrace();

			result.put("registration", "failure");
			return result;

		}
		

	}
	
	// 호스트 조회
	@GetMapping("/hosts/{name}") 
	public HostInfo hostInfo(@PathVariable("name") String name) {
		return hostDAO.selectHost(name);
	}
	
	// 호스트 수정
	@PatchMapping("/hosts/{name}") 
	public Map<String,Boolean> hostUpdate(
			@PathVariable("name") String name
			, @RequestParam("ip") String ip) {
		
		Map<String,Boolean> result = new HashMap<>();
		
		int z = 0;
		try {

			z = hostDAO.updateHost(name, ip);
			if (z == 1) {
				
				result.put("ipChange", true);
				return result;
				
			} else {
				result.put("ipChange", false);
				return result;
			}
			
		} catch (Exception e) {

			e.printStackTrace();

			result.put("ipChange", false);
			return result;

		}
	
	}
	
	// 호스트 삭제
	@DeleteMapping("/hosts/{name}") 
	public Map<String,Boolean> hostDelete(@PathVariable("name") String name) {
		
		Map<String,Boolean> result = new HashMap<>();
		
		if (hostDAO.deleteHost(name) == 1) {
			
			statusDAO.deleteStatus(name);
			
			result.put("hostDelete", true);
			return result;
			
		} else {
			result.put("hostDelete", false);
			return result;
		}
		
	}
}
