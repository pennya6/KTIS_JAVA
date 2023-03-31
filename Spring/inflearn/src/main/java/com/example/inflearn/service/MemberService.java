package com.example.inflearn.service;

import com.example.inflearn.domain.Member;
import com.example.inflearn.repository.MemberRepository;
import com.example.inflearn.repository.MemoryMemberRepository;

public class MemberService {
    private final MemberRepository memberRepository=new MemoryMemberRepository();

    private Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
    }
}
