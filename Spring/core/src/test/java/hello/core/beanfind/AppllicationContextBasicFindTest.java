package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class AppllicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("bean name find")
    void findBeanByName(){
       MemberService memberService =ac.getBean("memberService", MemberService.class);
       //memberService가 MemberServiceImpl이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("no name only type find")
    void findBeanByType(){
        MemberService memberService =ac.getBean( MemberService.class);
        //memberService가 MemberServiceImpl이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체타입으로 find")
    void findBeanByName2(){
        MemberService memberService =ac.getBean("memberService", MemberServiceImpl.class);
        //memberService가 MemberServiceImpl이면 성공
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("bean name no")
    void findBeanByNameNo(){
        //ac.getBean("xxxx",MemberService.class);
        //MemberService memberService=ac.getBean("xxxx",MemberService.class);
        
        //이 로직을 실행하면 터져야 성공
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxx",MemberService.class));
    }
}
