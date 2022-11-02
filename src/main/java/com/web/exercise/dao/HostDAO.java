package com.web.exercise.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.web.exercise.model.HostInfo;

@Repository
public interface HostDAO {
	
	public int insertHost(
			@Param("name") String name
			, @Param("ip") String ip);
	
	public int countHost();
	
	public HostInfo selectHost(@Param("name") String name);
	
	public int updateHost(
			@Param("name") String name
			, @Param("ip") String ip);

	public int deleteHost(@Param("name") String name);
	
	public String selectIP(@Param("name") String name);
	
	public List<List<String>> selectNameIp();
}
