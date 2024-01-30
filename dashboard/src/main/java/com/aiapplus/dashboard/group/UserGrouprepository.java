package com.aiapplus.dashboard.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserGrouprepository extends JpaRepository<UserGroupInfo,Long> {
    UserGroupInfo findByUserId(Long id);
}
