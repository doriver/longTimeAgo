package com.exercise.ex02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.ex02.dao.StoreDAO;
import com.exercise.ex02.model.Store;

@Service
public class StoreBO {

	@Autowired
	private StoreDAO storeDAO;
	
	public List<Store> getStore() {
		return storeDAO.selectStore();
	}
}
