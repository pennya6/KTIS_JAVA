package com.aiapplus.dashboard.user;

import com.aiapplus.dashboard.group.UserGroupInfo;
import com.aiapplus.dashboard.group.UserGrouprepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService { //UserDetailService : 스프링시큐리티제공하는 인터페이스 구현
    private final Userrepository userrepository;
    private final UserGrouprepository userGrouprepository;

    //사용자명으로 스프링 시큐리티의 사용자 객체를 조회하여 리턴하는 매서드
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<UserInfo> userInfo= Optional.ofNullable(this.userrepository.findUserIdByUsername(username));
        if(userInfo.isEmpty()){ //사용자가 없을시 예외 발생
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        UserInfo user=userInfo.get();
        List<GrantedAuthority> authorityList=new ArrayList<>();

        Long userId = user.getId(); //사용자 id 조회
        UserGroupInfo userGroupInfo = userGrouprepository.findByUserId(userId);
        Integer groupId=userGroupInfo.getGroupId();

        if(groupId.equals(1)){
            authorityList.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }else if(groupId.equals(2)){
            authorityList.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else{
            authorityList.add(new SimpleGrantedAuthority(UserRole.MANAGER.getValue()));
        }

        //사용자명, 비밀번호, 권한 리스트 전달
        return new User(user.getUsername(),user.getPassword(),authorityList);
    }
}
