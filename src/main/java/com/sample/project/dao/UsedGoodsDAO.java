package com.sample.project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sample.project.model.UsedGoods;


@Repository
public interface UsedGoodsDAO {
	public List<UsedGoods> selectUsedGoodsList();
}
