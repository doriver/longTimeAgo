package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@ResponseBody // 이게 없으면 안뜸
	@RequestMapping("/hello")
	public String helloWorld() {
		return "hello world";
	}
	
//	@ResponseBody // 이게 있으면 newfile 문자를 출력해버림**
	@RequestMapping("/jsp")
	public String jspFile() {
		return "NewFile";
	}
	
}
