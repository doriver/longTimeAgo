package com.exercise.ex04.dao;

import org.springframework.stereotype.Repository;

import com.exercise.ex04.model.NewStudent;

@Repository
public interface NewStudentDAO {
	public int insertNewStudent(NewStudent student);
}
