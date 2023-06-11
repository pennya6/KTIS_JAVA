package com.example.springboot.pagecontroller;

import com.example.springboot.dto.MemberRequestDTO;
import com.example.springboot.service.serviceImpl.MemberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
//2가지 종류
//string 다음으로 이동하는 페이지
//restController
public class PageController {

    private final MemberServiceImpl ms;
    @GetMapping("/")
    public String main(){
        return "index";
    }
    @PostMapping("/signup")
    //방법1
//    public String signup(String memberId,String memberPw){
//        System.out.println(memberId+memberPw);
//        return "index";
//    }

    //방법2
    //VO, DTO, entity
    //DB에 대한 정보를 감추기 위해서 DB에 컬럼과 다른명으로 변환하여 사용해야함
    public String signup(MemberRequestDTO requestDTO){
        ms.memberSignup(requestDTO);
        return "index";
    }
}
