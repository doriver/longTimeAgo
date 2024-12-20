package com.web.exercise;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {

	@Test
	public void lombokTest() {
		
		String name = "abcde";
		int amount = 3020;
		
		HelloResponseDto dto = new HelloResponseDto(name, amount);
		
		assertThat(dto.getName()).isEqualTo(name);
		assertThat(dto.getAmount()).isEqualTo(amount);
		// 검증 메소드
	}
}
