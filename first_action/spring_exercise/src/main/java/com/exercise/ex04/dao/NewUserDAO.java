package com.exercise.ex04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.exercise.ex04.model.NewUser;

@Repository
public interface NewUserDAO {
	public int insertNewUser(
			@Param("name") String name,
			@Param("yyyymmdd") String yyyymmdd,
			@Param("email") String email,
			@Param("introduce") String introduce
			);
	
	public NewUser selectLastUser();
	
	public NewUser selectUser(@Param("id") int id);
}
