package com.exercise.ex01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller은 해당 클래스가 스프링 MVC의 컨트롤러를 구현한 클래스라는 것을 지정한다.
@RequestMapping("/ex01-1")
@Controller // 없으면 안됨
public class Ex01Controller {

	@ResponseBody
	@RequestMapping("/1")
	public String printString() {
		String htmlText = "예제1번 <br> 문자열을 ResponseBody로 전달";
		return htmlText;
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> printMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 1500);
		map.put("banana", 2000);
		map.put("orrange", 1000);
		return map;
	} // {"banana":2000,"apple":1500,"orrange":1000}
	// web starter에 jackson 이라는 라이브러리가 있데
	// 크롬에 json설치 하면 다르게 보이는거 같은데?
	
	@RequestMapping("/3")
	public String jspView() {
		return "NewFile";
	}
	// ResponseBody 아닌 상태로 String 리턴하면, ViewResolver가 리턴된 String 이름의 view를 찾아 처리함
	
}
