package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount=1000; //1000원할인
    @Override
    public int discount(Member member, int price) {
        //vip이면 할인
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
