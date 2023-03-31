//package com.example.inflearn.repository;
//
//import com.example.inflearn.domain.Member;
//import org.junit.jupiter.api.AfterEach;
//import org.testng.annotations.Test;
//
//public class MemoryMemberRepositoryTest {
//    MemoryMemberRepository memoryMemberRepository=new MemoryMemberRepository();
//
//    @AfterEach
//    public void afterEach(){
//        memoryMemberRepository.clearStore();
//    }
//
//    @Test
//    public void save(){
//        Member member=new Member();
//        member.setName("spring");
//
//        memoryMemberRepository.save(member);
//
//        Member result=memoryMemberRepository.findById(member.getId()).get();
//        assertThat(result).isEqualTo(member);
//    }
//    @Test
//    public void findByName(){
//        Member member1=new Member();
//        member1.setName("spring 1");
//        memoryMemberRepository.save(member1);
//
//        Member member2=new Member();
//        member2.setName("spring2");
//        memoryMemberRepository.save(member2);
//
//        Member result=memoryMemberRepository.findByName("spring1").get();
//
//        assertThat(result).isEqualTo(member1);
//    }
//}
//
