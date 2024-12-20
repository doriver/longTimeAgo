package com.sb.basic.jpa.ex02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.sb.basic.jpa.ex02.model.CrudEntity;

public interface CrudEntityRepository extends JpaRepository<CrudEntity, String> {
	
	@Query(value = "select name, age from sample_member where name = :name", nativeQuery=true)
    List<CrudEntity> searchParamRepo(@Param("name") String name);
	// Controller에서 @GetMapping("searchParamRepo")에서만 필요
}
