package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    @DisplayName(" No spring nature DI container")
    void pureContainer(){
        AppConfig appConfig=new AppConfig();
        //1. 조회: 호출할때 마다 객체를 생성
        MemberService memberService1= appConfig.memberService();

        //2. 조회: 호출할때 마다 객체를 생성
        MemberService memberService2= appConfig.memberService();

        //참조값 확인
        System.out.println("1 = "+memberService1);
        System.out.println("2 = "+memberService2);

        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }
}
