package com.example.inflearn;

import com.example.inflearn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository=new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save(){
        Member member =new Member();
        member.setName("spring");

        memoryMemberRepository.save(member);

        Member result= memoryMemberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }
    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        Member result=memoryMemberRepository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);
        //when
        List<Member> result = memoryMemberRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);

    }
}
