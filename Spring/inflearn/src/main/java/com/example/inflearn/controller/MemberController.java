package com.example.inflearn.controller;

import com.example.inflearn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
<<<<<<< HEAD

=======
>>>>>>> e1f168c9c60b0d41295eca62ab21cff921f4c6f8
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }
}
