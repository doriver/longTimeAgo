package com.exercise.ex03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.ex03.bo.RealEstateBO;
import com.exercise.ex03.model.RealEstate;

@RestController
@RequestMapping("/ex33")
public class RealEstateRestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/1")
	public RealEstate ex01(
			@RequestParam(value="id") int id
			) {
		return realEstateBO.getRealEstate(id);
	}
	
	@RequestMapping("/2")
	public List<RealEstate> ex02(
			@RequestParam(value="rent") int rentPrice
			) {
		return realEstateBO.getRealEstateByRent(rentPrice);
	}
	
	@RequestMapping("/3")
	public List<RealEstate> ex03(
			@RequestParam(value="area") int area
			, @RequestParam(value="price") int price
			) {
		return realEstateBO.getRealEstateByAreaPrice(area, price);
	}
	
	@RequestMapping("/4")
	public String ex04() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(4);
		realEstate.setAddress("여의도");
		realEstate.setArea(20);
		realEstate.setType("매매");
		realEstate.setPrice(10000);
		realEstate.setRentPrice(100);
		
		int row = realEstateBO.addRealEstate(realEstate);
		return "insert 성공 : " + row;
	}
	
	@RequestMapping("/5")
	public String ex05(@RequestParam(value="realtorId") int realtorId) {
		int row = realEstateBO.addRealEstateByField(realtorId, "이태원", 17, "월세", 9000, 14);
		return "insert 성공 : " + row;
	}
	
	@RequestMapping("/6")
	public String ex06() {
		int row = realEstateBO.updateRealEstateById(1, "업뎃", 7777);
		return "수정성공 : " + row;
	}
	
	@RequestMapping("/7")
	public String ex07(@RequestParam(value="id") int id) {
		int row = realEstateBO.deleteRealEstateById(id);
		return "삭제성공 : " + row;
	}
}
