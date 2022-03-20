package com.exercise.ex02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exercise.ex02.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {
	public List<UsedGoods> selectUsedGoodsList();
}
