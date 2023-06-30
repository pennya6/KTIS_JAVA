package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;

    //private  final DiscountPolicy discountPolicy=new FixDiscountPolicy();

    //OrderServiceImpl의 경우 Fix,Rate등 직접적으로 의존하지 않는다.
    //단지 DiscountPolicy 인터페이스에 의존
    //단 OrderServiceImpl의 경우 어떤 구현객체가 들어올지 모른다.
    // 오직 Appconfig에서 결정
    private  final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        //좋은 구조 -> 할인에 대한 내용 수정 필요시 discountPolicy가서 고치면 끝
        int discountPrice=discountPolicy.discount(member,itemPrice);

        //주문만들어서 반환하면 끝
        return new Order(memberId,itemName,itemPrice,discountPrice); 
    }
}
