package com.example.demo;

import java.lang.reflect.Method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookTestJpaApplication {

	public static void main(String[] args) {
		
		// 문자열로 된 메소드 이름을 이용하여 해당 메소드를 동작시켜 봅시다.
		String methodName = "sub";
		Test test = new Test();
		int r = 0;
		try {
			Class<?> cls = Class.forName(test.getClass().getName());
			Method method = cls.getDeclaredMethod(methodName, Integer.class);
			r = (Integer)method.invoke(test, 5);
			System.out.println("메소드 실행 결과 : "+r);
		}catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		
		SpringApplication.run(BookTestJpaApplication.class, args);
	}
}
