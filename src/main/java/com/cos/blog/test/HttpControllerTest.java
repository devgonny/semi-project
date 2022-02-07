package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청->응답(html파일)
//@Controller

//사용자가 요청->응답(Data)

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest:";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("ssar").password("1234").email("@a.com").build();
		System.out.println(TAG+"getter:"+m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"getter:"+m.getUsername());
		return "lombok test 완료";
	}
	
	//인터넷브라우저 요청은 무조건 get요청밖에 할 수 없다.
	//http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		
		return "get 요청 : "+ m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8080/http/post (insert)
	@PostMapping("http/post") //text/plain         application/json
	public String postTest(@RequestBody Member m) { //MessageConverter가 담아줌((스프링부트)
		return   "post 요청 : "+ m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	//http://localhost:8080/http/put (update)
	@PutMapping("http/put")
	public String putTest() {
		return "put 요청";
	}
	//http://localhost:8080/http/delete (delete)
	@DeleteMapping("http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
