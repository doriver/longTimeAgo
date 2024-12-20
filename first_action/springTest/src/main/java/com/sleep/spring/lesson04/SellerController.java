package com.sleep.spring.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sleep.spring.lesson04.bo.SellerBO;
import com.sleep.spring.lesson04.model.Seller;

@RequestMapping("/lesson04")
@Controller
public class SellerController {
	@Autowired
	private SellerBO sellerBO;

	@GetMapping("/test01/1")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	@PostMapping("/test01/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImageUrl") String profileImageUrl
			, @RequestParam("temperature") String temperature
			) {
		
		int count = sellerBO.addSeller(nickname, profileImageUrl, temperature); 
				
		return "redirect:/lesson04/test01/seller_info";
	}

	@GetMapping("/test01/seller_info")
	public String getSellerInfo(
			Model model
			, @RequestParam(value="id", required=false) Integer id
			) {
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLastSeller();
		} else {
			seller = sellerBO.getSeller(id);
		}
		
		model.addAttribute("result", seller);
		model.addAttribute("subject", "판매자 정보");
		
		return "lesson04/sellerInfo";			
	}

	
	

}
