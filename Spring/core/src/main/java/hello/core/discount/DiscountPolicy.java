package hello.core.discount;

import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Autowired;

//인터페이스 -> 가이드라인 제공
@Autowired
public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     * **/
    int discount(Member member,int price);
}
