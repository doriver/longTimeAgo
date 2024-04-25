package com.sample.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sample.project.model.UsedGoods;


//@Repository // 이걸로 해도 되긴함
@Mapper
public interface UsedGoodsDAO {
	public List<UsedGoods> selectUsedGoodsList();
}
