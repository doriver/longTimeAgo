package com.sleep.spring.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/test02")
@RestController  // @Controller + @ResponseBody
public class Test02 {
	@RequestMapping("/1")
	public List<Map<String, Object>> printList() {
	    List<Map<String, Object>> list = new ArrayList<>();
	    Map<String, Object> map = new HashMap<String, Object>() {{ put("rate", "5"); put("director", "SBS"); put("time", "지상파"); put("title", "지상파");} };
	    list.add(map);
	    map = new HashMap<String, Object>() {{ put("rate", "5"); put("director", "SBS"); put("time", "지상파"); put("title", "지상파");} };
	    list.add(map);
	    map = new HashMap<String, Object>() {{ put("rate", "5"); put("director", "SBS"); put("time", "지상파"); put("title", "지상파");}};
	    list.add(map);
	    map = new HashMap<String, Object>() {{ put("rate", "5"); put("director", "SBS"); put("time", "지상파"); put("title", "지상파");}};
	    list.add(map);
	    map = new HashMap<String, Object>() {{ put("rate", "5"); put("director", "SBS"); put("time", "지상파"); put("title", "지상파");}};
	    list.add(map);
	    
	    return list;
	}
	
	@RequestMapping("/2")
	public List<BoardContent> boardList() {
		List<BoardContent> boardList = new ArrayList<>();
		BoardContent content = new BoardContent("가입인사", "하구르", "잘부탁드려요");
		
		boardList.add(content);
		return boardList;
	}
	
	@RequestMapping("/3")
	public ResponseEntity<BoardContent> entity() {
		BoardContent content = new BoardContent("가입인사", "하구르", "잘부탁드려요");
		
		ResponseEntity<BoardContent> entity = new ResponseEntity(content, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
}
