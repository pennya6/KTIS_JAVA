package com.example.springboot.repository;

import com.example.springboot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface MemberRepository extends JpaRepository<Member,String> {
}
