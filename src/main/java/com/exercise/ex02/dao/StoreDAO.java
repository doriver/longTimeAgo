package com.exercise.ex02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exercise.ex02.model.Store;

@Repository
public interface StoreDAO {
	public List<Store> selectStore();
}
