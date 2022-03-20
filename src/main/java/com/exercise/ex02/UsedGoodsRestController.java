package com.exercise.ex02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.ex02.bo.UsedGoodsBO;
import com.exercise.ex02.model.UsedGoods;

@RestController
public class UsedGoodsRestController {

	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	@RequestMapping("/ex02-1")
	public List<UsedGoods> ex01() {
		return usedGoodsBO.getUsedGoodsList();
	}
	
}
