package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MemberApp {
    //psv enter
    public static void main(String[] args) {
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService= appConfig.memberService();

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

        Member member=new Member(1L,"memberA", Grade.VIP);
        MemberService memberService=applicationContext.getBean("memberService", MemberService.class);

        memberService.join(member);

        Member findMember=memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }

}
