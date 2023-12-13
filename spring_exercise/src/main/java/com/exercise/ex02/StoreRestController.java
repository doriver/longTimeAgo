package com.exercise.ex02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.ex02.bo.StoreBO;
import com.exercise.ex02.model.Store;

@RestController
public class StoreRestController {

	@Autowired
	private StoreBO storeBO;
	
	@RequestMapping("/ex02-2")
	public List<Store> ex02() {
		return storeBO.getStore();
	}
}
