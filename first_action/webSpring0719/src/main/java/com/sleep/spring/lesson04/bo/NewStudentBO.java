package com.sleep.spring.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleep.spring.lesson04.dao.NewStudentDAO;
import com.sleep.spring.lesson04.model.NewStudent;

@Service
public class NewStudentBO {
	@Autowired
	private NewStudentDAO newStudentDAO;
	
	public int addStudent(NewStudent newStudent) {
		return newStudentDAO.insertNewStudent(newStudent);
	}

}
