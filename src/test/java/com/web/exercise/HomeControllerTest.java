package com.web.exercise;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// 스프링MVC 애플리케이션 형태로 테스트가 실행되도록 한다
@WebMvcTest(HomeController.class) // HomeController의 웹페이지 테스트
public class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc; // MockMvc을 주입
	// 실제 서버를 시작하는 대신 스프링MVC의 모의 메커니즘을 사용해도 충분, 모의 테스트를 하기위해 MockMvc이용
	
	/*
	 * MockMvc객체가 /의 HTTP GET 요청을 수행한후, 세가지중 어느 하나라도 중족하지 않으면 테스트는 실패한다
	 */
	@Test
	public void testHomePage() throws Exception{

		mockMvc.perform(get("/")) // Get /를 수행
		
		.andExpect(status().isOk()) // HTTP 200이 되어야 한다
		
		.andExpect(view().name("home")) // home뷰가 있어야한다
		
		.andExpect(content().string(containsString("Welcome to..."))); // 콘텐츠에 'Welcome to...'가 포함되어야 한다
	} 

}
