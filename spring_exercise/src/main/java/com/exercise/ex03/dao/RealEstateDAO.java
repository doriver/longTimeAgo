package com.exercise.ex03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.exercise.ex03.model.RealEstate;

@Repository
public interface RealEstateDAO {

	// id로 selelct하기
	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRealEstateByRent(@Param("rentPrice") int rentPrice);
	
	public List<RealEstate> selectRealEstateByAreaPrice(
			@Param("area") int area
			, @Param("price") int price
			);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateByField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") int rentPrice
			);
	
	public int updateRealEstateById(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price
			);
	
	public int deleteRealEstateById(@Param("id") int id);
}
