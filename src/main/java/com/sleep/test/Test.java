package com.sleep.test;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> goodsList = Arrays.asList(new String[]{ 
			    "저지방 우유", "요플레 4개", "딸기 1팩", "삼겹살 300g", "생수 6개", "주방 세제"
			});
		
		System.out.println(goodsList.get(0)); //저지방 우유
		System.out.println(goodsList.size()); // 6
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat day = new SimpleDateFormat("d");

		//cal.set(cal.YEAR, year);
		//cal.set(cal.MONTH, month-1); //1월이 0부터 시작하므로 월에서 -1

//		cal.set(Calendar.DAY_OF_MONTH,1); //DAY_OF_MONTH를 1로 설정 (월의 첫날)
//		int week = cal.get(Calendar.DAY_OF_WEEK); //그 주의 요일 반환 (일:1 ~ 토:7)
//		System.out.println(week);
		
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); //6 
		
		cal.set(Calendar.DAY_OF_MONTH,1);
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 5
		System.out.println(cal.get(Calendar.DAY_OF_WEEK) + 3); // 8
		System.out.println(cal.getActualMaximum(Calendar.DATE)); // 31



	}

}
