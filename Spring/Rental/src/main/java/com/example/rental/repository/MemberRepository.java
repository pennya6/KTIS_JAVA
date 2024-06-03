package com.example.rental.repository;

import com.example.rental.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface MemberRepository extends JpaRepository<Member,String> {
}
