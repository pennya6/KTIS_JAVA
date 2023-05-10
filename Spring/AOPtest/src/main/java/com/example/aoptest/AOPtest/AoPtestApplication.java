package com.example.aoptest.AOPtest;

import com.example.aoptest.AOPtest.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AoPtestApplication {

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("com/example/aoptest/AOPtest/applicationContext.xml");

        Student a = factory.getBean("studentA", Student.class);
        Student b = (Student) factory.getBean("studentB");

        System.out.println("A 입장");
        a.classWork();
        System.out.println("--------------");
        System.out.println("B 입장");
        b.classWork();
    }

}
