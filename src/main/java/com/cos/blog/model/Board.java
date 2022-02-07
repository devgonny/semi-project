package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private int id;
	
	@Column(nullable=false, length = 100)
	private String title;
	
	@Lob //대용량 데이터
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨. ->글자용량이 매우커질수잇음
	
	private int count; //조회수
	
	//아래 연관관계와 필드값 지정시 필드값 userId가 생성되고 FK로 연관관계가 맺어짐
	@ManyToOne(fetch=FetchType.EAGER) // 연관관계 =  Many=Board, User=One 여러개의 게시글은 한명의 유저에의해 쓰일수있다
	@JoinColumn(name="userId") //필드값 = userId
	private User user; //자바는 오브젝트를 저장할 수 있으나 DB는 저장할수없다. 그러나 jpa ORM(@Entity)을 사용하면 바로 객체로 저장할수있다.
	
	@OneToMany(mappedBy ="board", fetch=FetchType.EAGER) //mappedBy: 연관관계의 주인이 아니다.(난FK가 아니에요) DB에 컬럼만들지마세요
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	
	
}
