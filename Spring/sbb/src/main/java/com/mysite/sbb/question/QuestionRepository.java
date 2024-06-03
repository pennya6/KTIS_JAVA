package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//QuestionRepository 인터페이스를 리포지터리로 만들기 위해 JpaRepository 인터페이스 상속
//JpaRepository는 CRUD 작업을 처리하는 메서드들을 이미 내장하고 있어 데이터 처리를 보다 빠르게 진행
//<Question, Integer> : Question 엔티티로 리포지터리를 생성한다는 의미, 기본키가 Integer 임을 추가로 지정
public interface QuestionRepository extends JpaRepository<Question,Integer>{
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject,String content);
	List<Question> findBySubjectLike(String subject);
	Page<Question> findAll(Pageable pageable);

}
