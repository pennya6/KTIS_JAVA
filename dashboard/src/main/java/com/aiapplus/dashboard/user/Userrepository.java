package com.aiapplus.dashboard.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<UserInfo,Long> {
   UserInfo findUserIdByUsername(String username);
   UserInfo findByUsername(String username);

}
