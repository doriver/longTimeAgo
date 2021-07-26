package com.sleep.spring.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sleep.spring.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {
	public RealEstate selectRealEstate1(@Param("id") int id);
	public List<RealEstate> selectRealEstate2(@Param("rent") int rent);
											// xml쪽에 전달할 키워드
	public List<RealEstate> selectRealEstateAsArea(
			@Param("area") int area,
			@Param("price") int price);
	
	public int insertRealEstateFromObject(RealEstate realEstate);
}
