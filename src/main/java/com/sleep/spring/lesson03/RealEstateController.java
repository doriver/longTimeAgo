package com.sleep.spring.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sleep.spring.lesson03.bo.RealEstateBO;
import com.sleep.spring.lesson03.model.RealEstate;

@RestController
public class RealEstateController {
	@Autowired
	private RealEstateBO realestateBO;
	
	@RequestMapping("/lesson03/test01/1")
	public RealEstate test01_1(@RequestParam("id") int id) {
		return realestateBO.getRealEstate1(id);
	}

	@RequestMapping("/lesson03/test01/2")
	public List<RealEstate> test01_2(@RequestParam("rent") int rent) {
		return realestateBO.getRealEstate2(rent);
	}
}
