package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //questionRepository객체에 생성자방식으로 주입
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
    public Page<Question> getList(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.questionRepository.findAll(pageable);
    }

    public Question getQuestion(Integer id) {  
        Optional<Question> question = this.questionRepository.findById(id);
        return question.get();
    }
    
    public void create(String subject,String content) {
    	Question q=new Question();
    	q.setSubject(subject);
    	q.setContent(content);
    	q.setCreateDate(LocalDateTime.now());
    	this.questionRepository.save(q);
    }
}