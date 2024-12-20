package com.exercise.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exercise.ex04.bo.NewUserBO;
import com.exercise.ex04.model.NewUser;

@RequestMapping("/ex04")
@Controller
public class NewUserController {

	@Autowired
	private NewUserBO newUserBO;

	@RequestMapping(method = RequestMethod.GET, path ="/add_view")
	public String addUserView() {
		return "lesson04/addUser";
	}
	
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required = false) String introduce
			) {
		newUserBO.addNewUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser";
	}
	
//	@RequestParam(value="id") int id// 필수 파라미터
//	@RequestParam(value="id", required=true) int id// 필수 파라미터
//	@RequestParam(value="id", required=false) Integer id// 비 필수 파라미터
//	@RequestParam(value="id", defaultValue="1") int id
	
	@GetMapping("/user_view")
	public String getUserView(
			Model model, // view 화면에 데이터를 넘겨주는 객체
			@RequestParam(value="id", required = false) Integer id) { 
			// int가 null을 담을수 없다. Integer은 null을 담을수 있음
		NewUser newUser = new NewUser();
		
		if (id == null) {
			newUser = newUserBO.getLastUser();
		} else {			
			newUser = newUserBO.getUser(id);
		}
		
		
		model.addAttribute("result", newUser);
		model.addAttribute("subject", "회원정보");
		
		return "lesson04/userInfo";
	}
}
