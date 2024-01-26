package com.aiapplus.dashboard.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {
    private final Userrepository userrepository;
    private final PasswordEncoder passwordEncoder;

    public UserInfo create(Long id, String password,String email,String first_name,String last_name, Boolean isStaff, String department ,Integer companyid){
        UserInfo userInfo=new UserInfo();
        userInfo.setId(id);
        userInfo.setCompanyId(companyid);
        userInfo.setDepartment(department);
        userInfo.setEmail(email);
        userInfo.setFirstName(first_name);
        userInfo.setLastName(last_name);
        userInfo.setStaff(isStaff);
        userInfo.setPassword(passwordEncoder.encode(password));
        userInfo.setSuperuser(true);
        this.userrepository.save(userInfo);
        return userInfo;
    }

}
