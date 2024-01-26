package com.aiapplus.dashboard.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<UserInfo,Long> {

}
