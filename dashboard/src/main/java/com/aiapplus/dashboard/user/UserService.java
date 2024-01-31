package com.aiapplus.dashboard.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class UserService {
    private final Userrepository userrepository;
    private final PasswordEncoder passwordEncoder;

    public UserInfo create(String username, String password, String email, String first_name, String last_name, Boolean isStaff, String department , Integer companyid, LocalDateTime datetime,String status){
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername(username);
        userInfo.setCompanyId(companyid);
        userInfo.setDepartment(department);
        userInfo.setEmail(email);
        userInfo.setFirstName(first_name);
        userInfo.setLastName(last_name);
        userInfo.setStaff(isStaff);
        userInfo.setPassword(passwordEncoder.encode(password));
        userInfo.setSuperuser(true);
        Date dateJoined = Date.from(datetime.atZone(ZoneId.systemDefault()).toInstant());
        userInfo.setDateJoined(dateJoined);
        userInfo.setStatus(status);
        this.userrepository.save(userInfo);
        return userInfo;
    }
    public Long findUserIdByUsername(String username){
        UserInfo user=userrepository.findUserIdByUsername(username);
        return user.getId();

    }

    public UserInfo getUserByUsername(String username) {
        UserInfo userInfo=userrepository.findByUsername(username);
        return userInfo;
    }
}
