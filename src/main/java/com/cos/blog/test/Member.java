package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@RequiredArgsConstructor   -> 밑에 final 붙인경우
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}	
	
	
}
