package com.sleep.spring.lesson05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	@GetMapping("/ex01")
	public String ex01() {
		return "/lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		List<String> fruits = new ArrayList<>();
		fruits.add("banana");
		fruits.add("apple");
		fruits.add("peach");
		fruits.add("mango");
		
		model.addAttribute("fruits", fruits);
		
		return "/lesson05/ex02";
	}
}
