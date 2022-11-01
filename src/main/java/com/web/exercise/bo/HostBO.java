package com.web.exercise.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.exercise.dao.HostDAO;

@Service
public class HostBO {

	@Autowired
	private HostDAO hostDAO;
	
	public boolean insertable() {
		
		boolean result;
		
		if (hostDAO.countHost() >= 5) {
			result = false;
		} else {
			result = true;
		}
		
		return result;
	}
}
