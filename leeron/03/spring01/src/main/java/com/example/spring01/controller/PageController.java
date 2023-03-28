package com.example.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String mainPage(){
        return "main"; //main.html을 자동으로 확인
    }
}