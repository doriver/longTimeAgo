package com.sample.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.project.bo.UsedGoodsBO;
import com.sample.project.model.UsedGoods;


@RestController
public class UsedGoodsRestController {
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/goods")
	public List<UsedGoods> ex01() {
		
		logger.info("[UsedGoodsRestController.ex01]");
		return usedGoodsBO.getUsedGoodsList();
	}
}
