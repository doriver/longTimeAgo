package com.sleep.spring.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sleep.spring.lesson04.bo.NewStudentBO;
import com.sleep.spring.lesson04.model.NewStudent;

@RequestMapping("/lesson04/ex02")
@Controller
public class NewStudentController {
	
	@Autowired
	private NewStudentBO newStudentBO;

	@GetMapping("/1")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	
	@GetMapping("/add_student")
	public String addStudent(
			@ModelAttribute NewStudent newStudent
			, Model model) {
		
		newStudentBO.addStudent(newStudent);
		
		model.addAttribute("result", newStudent);
		
		return "lesson04/studentInfo";
	}
}