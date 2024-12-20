package com.exercise.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ex01-2")
@RestController // @Controller + @ResponseBody
public class Ex01RestController {

	@RequestMapping("/1")
	public String printString() {
		return "@RestController 사용한 String 리턴";
	}
	
	@RequestMapping("/2")
	public Map<String, String> printMap() {
		Map<String, String> map = new HashMap<>();
		map.put("유재석", "개그맨");
		map.put("아이유", "가수");
		map.put("홍길도", "김삿갓");
		return map;
	} // {"홍길도":"김삿갓","유재석":"개그맨","아이유":"가수"}
	
	@RequestMapping("/3")
	public Data printData() {
		Data data = new Data();
		data.setId(1);
		data.setName("김또깡");
		return data;
	} // {"id":1,"name":"김또깡"}
	
	@RequestMapping("/4")
	public List<Map<String, Object>> movieList() {
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movie = new HashMap<>();
		movie.put("title", "기생충");
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("rate", 15);
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("title", "인생은 아름다워");
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("rate", 0);
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("title", "인셉션");
		movie.put("director", "크리스토퍼 놀란");
		movie.put("time", 147);
		movie.put("rate", 12);
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("title", "범죄와의 전쟁");
		movie.put("director", "윤종빈");
		movie.put("time",133);
		movie.put("rate", 19);
		movieList.add(movie);
		
		return movieList;
	}
	
	@RequestMapping("/5")
	public List<BoardContent> boardList() {
		List<BoardContent> boardList = new ArrayList<>();
		
		BoardContent content = new BoardContent();
		content.setTitle("안녕하세요 가입인사");
		content.setUser("wqetq");
		content.setContent("ㅎ2");
		boardList.add(content);
		
		content = new BoardContent();
		content.setTitle("헐 대박");
		content.setUser("yoyoyo");
		content.setContent("오늘 목요일이였네");
		boardList.add(content);
		
		content = new BoardContent();
		content.setTitle("돈 날릴");
		content.setUser("game");
		content.setContent("손절 했는데 틀렸음");
		boardList.add(content);
		
		return boardList;
	}
	
	
}
