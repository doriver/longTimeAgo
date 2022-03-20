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
	
	@GetMapping("/user_view")
	public String getUserView(Model model) { // view 화면에 데이터를 넘겨주는 객체
		NewUser newUser = newUserBO.getLastUser();
		model.addAttribute("result", newUser);
		model.addAttribute("subject", "회원정보");
		
		return "lesson04/userInfo";
	}
}
