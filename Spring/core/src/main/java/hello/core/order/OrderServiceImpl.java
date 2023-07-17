package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
//lombok -> final이 붙어있는 필드를 모아서 생성자 자동 만듬
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;

    //private  final DiscountPolicy discountPolicy=new FixDiscountPolicy();

    //OrderServiceImpl의 경우 Fix,Rate등 직접적으로 의존하지 않는다.
    //단지 DiscountPolicy 인터페이스에 의존
    //단 OrderServiceImpl의 경우 어떤 구현객체가 들어올지 모른다.
    // 오직 Appconfig에서 결정

    private final DiscountPolicy discountPolicy;

    @Autowired
    //생성자 한개면 생략해도 자동 주입 가능
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Autowired
    public DiscountPolicy setDiscountPolicy(@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        //좋은 구조 -> 할인에 대한 내용 수정 필요시 discountPolicy가서 고치면 끝
        int discountPrice=discountPolicy.discount(member,itemPrice);

        //주문만들어서 반환하면 끝
        return new Order(memberId,itemName,itemPrice,discountPrice); 
    }
}
