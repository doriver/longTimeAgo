package com.exercise.ex02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.ex02.dao.UsedGoodsDAO;
import com.exercise.ex02.model.UsedGoods;

@Service
public class UsedGoodsBO {

	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsDAO.selectUsedGoodsList();
	}
	
}
