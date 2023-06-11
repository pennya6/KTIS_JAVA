package com.example.inflearn.service;

import com.example.inflearn.domain.Member;
import com.example.inflearn.repository.MemberRepository;
import com.example.inflearn.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
=======
>>>>>>> e1f168c9c60b0d41295eca62ab21cff921f4c6f8

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
<<<<<<< HEAD

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
=======
    //회원 리포지토리
    private final MemberRepository memberRepository = new MemoryMemberRepository();
>>>>>>> e1f168c9c60b0d41295eca62ab21cff921f4c6f8

    //회원 가입
    public Long join(Member member){
        // 같은 이름을 가진 중복 이름 받을 수 없음
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
