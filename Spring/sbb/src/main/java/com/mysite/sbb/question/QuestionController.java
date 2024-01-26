package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor //애너테이션 생성자 방식으로 questionRepository 객체 주입 -> final이 붙은 속성을 포함한 생성자 자동으로 만들어줌
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping("/list")
	public String list(Model model,@RequestParam(value="page",defaultValue = "0")int page) {
		Page<Question> questionList = questionService.getList(page);
		model.addAttribute("paging", questionList);
		return "question_list";
	}
	
	@GetMapping(value="/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id,AnswerForm answerForm) {
		Question question=this.questionService.getQuestion(id);
		model.addAttribute("question",question);
		return "question_detail";
	}
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
//	@PostMapping("/create")
//	public String questionCreate(@RequestParam(value="subject") String subject,@RequestParam(value="content") String content) {
//		this.questionService.create(subject, content);
//		return "redirect:/question/list";
//	}
	
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";
	}

}
