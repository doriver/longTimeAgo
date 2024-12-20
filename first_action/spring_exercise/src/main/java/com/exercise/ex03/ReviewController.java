package com.exercise.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.ex03.bo.ReviewBO;
import com.exercise.ex03.model.Review;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost:8080/ex03-1?id=1
	@RequestMapping("/ex03-1")
	public Review ex01(@RequestParam(value="id") int id) {
		System.out.println("### id " + id);
		return reviewBO.getReview(id);
	}
	
	@RequestMapping("/ex03-2")
	public String ex02() {
		Review review = new Review();
		review.setStoreId(99);
		review.setMenu("자담치킨");
		review.setUserName("석렬");
		review.setPoint(1.3);
		review.setReview("마싯네");
		
		int row = reviewBO.addReview(review);
//		int row = reviewBO.addReviewAsField(4, "피자", "리쌍", 3.2, "할인받아");
		return "insert row count : " + row;
	}
	
	@RequestMapping("/ex03-3")
	public String ex03(
			@RequestParam(value="id") int id,
			@RequestParam(value="review") String review
			) {
		int row = reviewBO.updateReviewById(id, review);
		return "update성공" + row;
	}
	
	@RequestMapping("/ex03-4")
	public String ex04(
			@RequestParam(value="id") int id
			) {
		int row = reviewBO.deleteReviewById(id);
		return "delete 성공 " + row;
	}
}
