package com.web.exercise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/") // 루트경로인 /의 웹 요청을 처리
	public String home() {
		return "home"; // 뷰 이름을 반환
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@ResponseBody
	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(
			@RequestParam("name") String name, // 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
			@RequestParam("amount") int amount
			) {
		return new HelloResponseDto(name, amount);
	}
}
