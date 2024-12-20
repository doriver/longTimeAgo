package com.sleep.spring.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sleep.spring.lesson06.bo.FavoriteBO;
import com.sleep.spring.lesson06.model.Favorite;

@RequestMapping("/lesson06/test01")
@Controller
public class FavoriteController {
	@Autowired	
	private FavoriteBO favoriteBO;
	
	@GetMapping("/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/addFavorite";
	}
	
	@PostMapping("/add_favorite")
	@ResponseBody
	public Map<String, String> addFavorite(
			@RequestParam("title") String title
			, @RequestParam("url") String url) {
		
		int count = favoriteBO.addFavorite(title, url);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");	
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@GetMapping("/favorite_list") 
	public String favoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "lesson06/favoriteList";
	}
	
	@PostMapping("/is_duplication")
	@ResponseBody
	public Map<String, Boolean> isDuplication(
			@RequestParam("url") String url) {
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(favoriteBO.existFavoriteUrl(url)) {
			result.put("isDuplicate", true);
		} else {
			result.put("isDuplicate", false);
		}
		
		return result;
	}
	
	@GetMapping("/delete_favorite")
	@ResponseBody
	public Map<String, String> delete(
			@RequestParam("id") int id) {
		Map<String, String> result = new HashMap<>();
		
		int count = favoriteBO.deleteFavorite(id);
		if (count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
			result.put("message", "삭제에 실패");
		}
		
		return result;
	}
}