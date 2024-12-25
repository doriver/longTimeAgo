package com.sample.project.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.project.dao.UsedGoodsDAO;
import com.sample.project.model.UsedGoods;

@Service
public class UsedGoodsBO {
	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<UsedGoods> getUsedGoodsList() {
		logger.info("[UsedGoodsBO.getUsedGoodsList]");
		return usedGoodsDAO.selectUsedGoodsList();
	}
}
