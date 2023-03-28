package com.example.spring01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoController {

    private ArrayList<String> todolist=new ArrayList<>();

    //json ajax방식은 restful 방식
    @GetMapping("/list")
    public ArrayList<String> mainPage(){
        return todolist; //string값
    }

    @GetMapping("/receiveList")
    public ArrayList<String> receiveList(String todo){ //todo라는 이름으로 들어옴, 밖에서 들어오는 구멍
        todolist.add(todo);
        return todolist; //string값
    }

    @GetMapping("/deleteList")
    public ArrayList<String> deleteList(int todo){ //todo라는 이름으로 들어옴, 밖에서 들어오는 구멍
        todolist.remove(todo);
        return todolist; //string값
    }


}