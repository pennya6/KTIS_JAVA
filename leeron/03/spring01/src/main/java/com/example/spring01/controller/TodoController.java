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

//    @GetMapping("/receiveList")
//    public ArrayList<String> receiveList(String todo){ //todo라는 이름으로 들어옴, 밖에서 들어오는 구멍
//        todolist.add(todo);
//        return todolist; //string값
//    }

    @GetMapping("/deleteList")
    public ArrayList<String> deleteList(int todo){ //todo라는 이름으로 들어옴, 밖에서 들어오는 구멍
        todolist.remove(todo);
        return todolist; //string값
    }

    @GetMapping("/receiveList")
    public ArrayList<String> receiveList(String todo){ //todo라는 이름으로 들어옴, 밖에서 들어오는 구멍
        //중복확인
        boolean check=checkList(todo);
        if (check==false){
            todolist.add(todo);
        }
        return todolist; //string값
    }

    public boolean checkList(String todo){
        boolean isDuplicated=false; //중복아님

        for(int i=0;i<todolist.size();i++){
            if(todolist.get(i).equals(todo)){
                isDuplicated=true;
            }
        }
        return isDuplicated;
    }

    //단어 입력시 단어가 있는 거 삭제
    @GetMapping("/deleteword")
    public ArrayList<String> deleteWord(String todo){ //todo라는 이름으로 들어옴, 밖에서 들어오는 구멍
        boolean check=checkList(todo); //중복확인
        if (check==true) {
            todolist.remove(todo);
            System.out.println("delete");
        }
        return todolist; //string값
    }

}