package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//이거를 추가함으로써 com.exercise - 클래스들에 설정한 주소들이 브라우저에 띄워짐 but 이 패키지에 있는건 반대로 안됨

@ComponentScan(basePackages = "com.exercise.*")  
@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

}
