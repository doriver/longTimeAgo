package com.sleep.spring.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleep.spring.lesson03.dao.RealEstateDAO;
import com.sleep.spring.lesson03.model.RealEstate;

@Service
public class RealEstateBO {
	@Autowired
	private RealEstateDAO realEstateDAO;
	
	public RealEstate getRealEstate1(int id) {
		return realEstateDAO.selectRealEstate1(id);
	}
	//getRealEstateAsRent 전치사 써서 해줌
	public List<RealEstate> getRealEstate2(int rent) {
		return realEstateDAO.selectRealEstate2(rent);
	}
	
	public List<RealEstate> getRealEstateAsArea(int area, int price) {
		return realEstateDAO.selectRealEstateAsArea(area, price);
	}
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateDAO.
	}
}
