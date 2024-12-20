package com.sleep.spring.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleep.spring.lesson04.dao.SellerDAO;
import com.sleep.spring.lesson04.model.Seller;

@Service
public class SellerBO {
	@Autowired
	private SellerDAO sellerDAO;
	
	public int addSeller(String nickname, String profileImageUrl, String temperature) {
		return sellerDAO.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	public Seller getLastSeller() {
		return sellerDAO.selectLastSeller();
	}

	public Seller getSeller(int id) {
		return sellerDAO.selectSeller(id);
	}
}
