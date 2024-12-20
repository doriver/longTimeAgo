package com.sleep.spring.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleep.spring.lesson02.dao.UsedGoodsDAO;
import com.sleep.spring.lesson02.model.UsedGoods;

// 비지니스 로직
@Service
public class UsedGoodsBO {
	
	//호출할 매소드
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsDAO.selectUsedGoodsList();
	}
}
