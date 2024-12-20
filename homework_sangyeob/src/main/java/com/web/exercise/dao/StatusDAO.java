package com.web.exercise.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.web.exercise.model.AliveStatus;

@Repository
public interface StatusDAO {

	public int insertStatus(@Param("name") String name);
	
	public int updateStatus(@Param("name") String name
			, @Param("alive") boolean alive);

	public int updateOnlyAlive(@Param("name") String name
			, @Param("alive") boolean alive);
	
	public AliveStatus selectStatus(@Param("name") String name);
	
	public List<AliveStatus> selectAllStatus();
	
	public int deleteStatus(@Param("name") String name);
}
