package com.sb.basic.jpa.ex01;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MemoRepository extends JpaRepository<Memo, Long> {

}
