package com.exercise.ex04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.ex04.dao.NewStudentDAO;
import com.exercise.ex04.model.NewStudent;

@Service
public class NewStudentBO {

	@Autowired
	private NewStudentDAO newStudentDAO;
	
	public int addNewStudent(NewStudent student) {
		return newStudentDAO.insertNewStudent(student);
	}
}
