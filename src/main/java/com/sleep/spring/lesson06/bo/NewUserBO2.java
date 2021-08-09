package com.sleep.spring.lesson06.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleep.spring.lesson06.dao.NewUserDAO2;

@Service
public class NewUserBO2 {
	@Autowired
	private NewUserDAO2 newUserDAO;
	
	public int addNewUser(String name, String yyyymmdd, String email, String introduce) {
		return newUserDAO.insertNewUser(name, yyyymmdd, email, introduce);
	}
	
	public boolean existName(String name) {
		
		if (newUserDAO.selectCountName(name) == 0) {
			return false;
		} else {
			return true;
		}
		
	}
}
