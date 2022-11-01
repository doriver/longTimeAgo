package com.web.exercise.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDAO {

	public int insertStatus(@Param("name") String name);
	
	public int updateStatus(@Param("name") String name
			, @Param("alive") boolean alive);
}
