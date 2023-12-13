package com.exercise.ex05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ex05")
@Controller
public class Ex05Controller {

	@RequestMapping("/1")
	public String ex01() {
		return "ex05/1";
	}
	
	@RequestMapping("/2")
	public String ex02(Model model) {
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("melon");
		fruits.add("peach");
		fruits.add("grape");
		
		model.addAttribute("fruits", fruits);
		
		List<Map<String,Object>> users = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		map.put("name","홍길동");
		map.put("age", 34);
		map.put("hobby", "동해번쩍");
		users.add(map);
		
		map = new HashMap<>();
		map.put("name","루피");
		map.put("age", 16);
		map.put("hobby", "고무고무");
		users.add(map);
		
		model.addAttribute("users", users);
		
		return "ex05/2";

	}
}
