package com.sleep.spring.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sleep.spring.lesson03.bo.ReviewBO;
import com.sleep.spring.lesson03.model.Review;

@RestController
public class ReviewController {
	@Autowired
	private ReviewBO reviewBO;
	
	@RequestMapping("/lesson03/ex01")
	// /lesson03/ex01?id=3
	public Review ex01(
			//파라미터 받는 방법들
			//@RequestParam(value="id") int id // 필수, 없으면400에러
			//@RequestParam(value="id", required=true) int id // 필수, 없으면400에러
			//@RequestParam(value="id", required=false) int id // 필수 아님
			//@RequestParam(value="id", defaultValue="1") int id
			@RequestParam("id") int id
			
			) {
		return reviewBO.getReview(id);
	}
}
