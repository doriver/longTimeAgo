package com.exercise.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercise.ex04.bo.NewStudentBO;
import com.exercise.ex04.model.NewStudent;

@RequestMapping("/ex44")
@Controller
public class NewStudentController {

	@Autowired
	private NewStudentBO newStudentBO;
	
	@GetMapping("/input")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute NewStudent student,
			Model model
			) {
		newStudentBO.addNewStudent(student); // 추가된 데이터의 PK를 얻어낸다.
		// usedGeneratedKey와 keyProperty로 인해 id값이 객체에 채워진 상태가 된다.
		
		model.addAttribute("result", student);
		model.addAttribute("subject", "학생정보");
		
		return "lesson04/studentInfo";
	}
}
