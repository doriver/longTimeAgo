package com.sleep.spring.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sleep.spring.lesson03.bo.RealEstateBO;
import com.sleep.spring.lesson03.model.RealEstate;

@RestController
@RequestMapping("/lesson03")
public class RealEstateController {
	@Autowired
	private RealEstateBO realestateBO;
	
	// http://localhost/lesson03/test01/1?id=22
	@RequestMapping("/test01/1")	//파라미터 받는키워드, 실제값
	public RealEstate test01_1(@RequestParam("id") int id) {
		return realestateBO.getRealEstate1(id);
	}

	@RequestMapping("/test01/2")
	public List<RealEstate> test01_2(@RequestParam("rent") int rent) {
		return realestateBO.getRealEstate2(rent);
	}
	
	@RequestMapping("/test01/3")
	public List<RealEstate> test01_3 (
			@RequestParam(value="area") int area,
			@RequestParam(value="price") int price
			) {
		return realestateBO.getRealEstateAsArea(area, price);
	}
	
	@RequestMapping("/test02/1")
	public String test02_1() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(1000000);
		
		int count = realestateBO
		
	}
}
