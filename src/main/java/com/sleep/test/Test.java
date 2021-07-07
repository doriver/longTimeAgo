package com.sleep.test;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> goodsList = Arrays.asList(new String[]{ 
			    "저지방 우유", "요플레 4개", "딸기 1팩", "삼겹살 300g", "생수 6개", "주방 세제"
			});
		
		System.out.println(goodsList.get(0)); //저지방 우유
		System.out.println(goodsList.size()); // 6
	}

}
