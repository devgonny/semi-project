package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //파일을 리턴하라
public class TempControllerTest {
	
//	localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일리턴 기본경로: src/main/resources/static
		//리턴명: /home.html 앞에 /를 붙여줘야 위에 기본경로와 붙음
		
		return "/home.html";
	}
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/1.png";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		//prefix: 
		//suffix:
		//풀네임: ~~적용돼서 찾아짐
		return "test";  //동적파일이라 인식불가 -> yml에 프리픽스서픽스적용
	}

}
