package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonService {
    //싱글톤패턴
    // -> 클래스의 인스턴스가 1개만 생성되는것을 보장, 2개 이상 생성하지못하도록 막는다(private 생성자를 사용

    //1. static 영역에 객체를 딱 1개만 생성
    private  static final SingletonService getInstance=new SingletonService();

    //2. public 으로 열어서 객체 인스턴스 필요시 이 static 메서드를 통해서 조회
    public static SingletonService getInstance(){
        //필요하면 오직 getInstance로만 조회가능
        return getInstance;
    }
    
    //3. 생성자를 private으로 선언해서 외부에서 new키워드를 사용한 객체 생성을 못하게 막기
    private SingletonService(){
        
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1=ac.getBean("memberService",MemberService.class);
        MemberService memberService2=ac.getBean("memberService",MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }


}
