package com.sleep.spring.lesson06.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewUserDAO2 {
	public int insertNewUser(
			@Param("name") String name
			, @Param("yyyymmdd") String yyyymmdd
			, @Param("email") String email
			, @Param("introduce") String introduce);
	
	//
	public int selectCountName(@Param("name") String name);

}
