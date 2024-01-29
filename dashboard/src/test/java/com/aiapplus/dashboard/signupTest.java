package com.aiapplus.dashboard;

import com.aiapplus.dashboard.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class signupTest {

    @Autowired
    private UserService userService;

    @Test
    public void testValidSignup(){
        String username="admin";
        String password="admin";
        String lastName="admin";
        String firstName="admin";
        String email="admin@kt.com";
        String department="AICC솔루션사업팀";
        Integer companyId=1;
        boolean staff=true;
        this.userService.create(username,password,email,firstName,lastName,staff,department,companyId, LocalDateTime.now(),"미승인");
    }
}
