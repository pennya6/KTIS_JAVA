package com.aiapplus.dashboard;

import com.aiapplus.dashboard.group.UserGroupInfo;
import com.aiapplus.dashboard.group.UserGrouprepository;
import com.aiapplus.dashboard.user.UserInfo;
import com.aiapplus.dashboard.user.UserRole;
import com.aiapplus.dashboard.user.UserService;
import com.aiapplus.dashboard.user.Userrepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class signupTest {

    @Autowired
    private UserService userService;

    @Autowired
    private Userrepository userrepository;

    @Autowired
    private UserGrouprepository userGrouprepository;

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

    @Test
    public void testLogin(){
        Optional<UserInfo> userInfo=Optional.ofNullable(this.userrepository.findUserIdByUsername("admin"));
        UserInfo user=userInfo.get();
        Long userId=user.getId();
        System.out.println("ID:"+userId);
        List<GrantedAuthority> authorityList=new ArrayList<>();

        UserGroupInfo userGroupInfo = userGrouprepository.findByUserId(userId);
        Integer groupId=userGroupInfo.getGroupId();

        if(groupId.equals(1)){
            authorityList.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }else if(groupId.equals(2)){
            authorityList.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else{
            authorityList.add(new SimpleGrantedAuthority(UserRole.MANAGER.getValue()));
        }
        System.out.println("test : "+user.getUsername()+user.getPassword()+authorityList);
    }
}
