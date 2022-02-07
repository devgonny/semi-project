package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.User;

//자동으로 bean으로 등록이 된다. -> //@Repository 생략가능하다
//jparepository 컨트롤클릭하면 함수 엄청많음 이기능을 다 상속하니 기본적인 crud는 다가능
public interface UserRepository extends JpaRepository<User, Integer>{ 
	//SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);

}



//로그인 방식 시큐리티로 바귀기전 코드 공부용~
//JPA naming 쿼리
//select * from user where username=? and password=? 가 동작함
//User findByUsernameAndPassword(String username, String password);

//위와 같음. 둘다가능
//@Query(value="select * from user where username=? and password=? ", nativeQuery = true)
//User login(String username, String password);
