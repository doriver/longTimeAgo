package com.exercise.ex04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.ex04.dao.RealtorDAO;
import com.exercise.ex04.model.Realtor;

@Service
public class RealtorBO {
	@Autowired
	private RealtorDAO realtorDAO;
	
	public int addRealtor(Realtor realtor) {
		return realtorDAO.insertRealtor(realtor);
	}
	
	public Realtor getRealtor(int id) {
		return realtorDAO.selectRealtor(id);
	}
}
