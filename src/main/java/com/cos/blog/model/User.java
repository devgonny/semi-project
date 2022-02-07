package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//ORM -> JAVA(그외다른모든언어) object => 테이블로 매핑해주는 기술
@Entity //User클래스가 MySQL에 자동으로 테이블이 생성이된다.
//@DynamicInsert // 인서트시 null인 필드를 제외하고 쿼리문작성
public class User {

	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // auto_increment
	
	@Column(nullable = false, length = 30, unique=true)
	private String username;
	
	@Column(nullable = false, length = 100) // 123456~ => 해쉬(비밀번호 암호화)로 길어질수있어서 넉넉하게
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	 
	//@ColumnDefault("user")
	//DB에는 RoleTyle이 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; //정확하게 하려면 Enum을 쓰는게좋음. -> ADMIN, USER, manager 등 도메인범위를 한정할수잇음
	
	
	@CreationTimestamp //시간이 자동입력
	private Timestamp createDate;
	
}
