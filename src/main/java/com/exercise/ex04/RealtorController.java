package com.exercise.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercise.ex04.bo.RealtorBO;
import com.exercise.ex04.model.Realtor;

@Controller
@RequestMapping("/ex444")
public class RealtorController {
	@Autowired
	private RealtorBO realtorBO;
	
	@GetMapping("/1")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model
			) {
		realtorBO.addRealtor(realtor);
		
		Realtor result = realtorBO.getRealtor(realtor.getId());
		
		model.addAttribute("title", "공인중개사 정보");
		model.addAttribute("result", result);
		
		return "lesson04/realtorInfo";
	}
}
