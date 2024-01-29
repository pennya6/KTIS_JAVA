package com.aiapplus.dashboard.group;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGroupService {
    private final UserGrouprepository userGrouprepository;

    public UserGroupInfo create(Long userId,Integer groupId){
        UserGroupInfo userGroupInfo=new UserGroupInfo();
        userGroupInfo.setGroupId(groupId);
        userGroupInfo.setUserId(userId);
        this.userGrouprepository.save(userGroupInfo);
        return userGroupInfo;
    }
}
