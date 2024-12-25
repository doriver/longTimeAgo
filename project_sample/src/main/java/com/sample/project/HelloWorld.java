package com.sample.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {

	@ResponseBody
	@RequestMapping("/hello")
	public String helloWorld() {
		return "hello world";
	}
	
    @RequestMapping("/jspp")
    public String ex02() {  
        return "test/hello"; 
    }
    
    
}
