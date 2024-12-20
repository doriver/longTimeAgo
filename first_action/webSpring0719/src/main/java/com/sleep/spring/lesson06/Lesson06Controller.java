package com.sleep.spring.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sleep.spring.lesson06.bo.NewUserBO2;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	// 데이터 insert를 아작스 이용해서?
	@Autowired
	private NewUserBO2 newUserBO;
	
	@GetMapping("/add_user_view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	@PostMapping("/add_user")
	@ResponseBody
	public Map<String,String> addUser(
			@RequestParam("name") String name
			, @RequestParam("yyyymmdd") String yyyymmdd
			, @RequestParam(value="email", required=false) String email
	 		, @RequestParam("introduce") String introduce)
	{
		newUserBO.addNewUser(name, yyyymmdd, email, introduce);
		Map<String,String> result = new HashMap<>();
		result.put("result", "success");
		return result;
	}
	
	@GetMapping("/is_duplication")
	@ResponseBody
	public Map<String, String> isDuplication(
			@RequestParam("name") String name
			) {
		Map<String,String> result = new HashMap<>();
		
		if (newUserBO.existName(name)) {
			result.put("isDuplicate", "true");
		} else {
			result.put("isDuplicate", "false");
		}
		
		return result;
	}
}
