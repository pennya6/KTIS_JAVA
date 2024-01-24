package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	@Id //id속성을 기본키로 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //고유한 번호를 생성하는 방법
	private Integer id; //고유번호
	
	@Column(length=200)
	private String subject; //제목
	
	@Column(columnDefinition="TEXT") //텍스트를 열 데이터로 넣을 수 있음을 의미
	private String content; //내용
	
	private LocalDateTime createDate; //작성일시
	
	@OneToMany(mappedBy="question",cascade=CascadeType.REMOVE) // 게시판 삭제시 그에 달린 답변까지 삭제되도록 지정
	private List<Answer> answerList;
	

}
