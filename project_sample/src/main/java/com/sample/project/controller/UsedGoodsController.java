package com.sample.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sample.project.bo.UsedGoodsBO;
import com.sample.project.model.UsedGoods;

@Controller
public class UsedGoodsController {

	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	@GetMapping("/jsp/goods")
	public String goodsJsp(Model model) {
		
		List<UsedGoods> goodsList = usedGoodsBO.getUsedGoodsList();
		
		model.addAttribute("goodsList", goodsList);
//		model.addAttribute(goodsList);
		
		return "test/goodsList";
	}
}
