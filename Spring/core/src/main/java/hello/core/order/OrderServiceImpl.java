package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository=new MemoryMemberRepository();
    //private  final DiscountPolicy discountPolicy=new FixDiscountPolicy();
    private  final DiscountPolicy discountPolicy=new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        //좋은 구조 -> 할인에 대한 내용 수정 필요시 discountPolicy가서 고치면 끝
        int discountPrice=discountPolicy.discount(member,itemPrice);

        //주문만들어서 반환하면 끝
        return new Order(memberId,itemName,itemPrice,discountPrice); 
    }
}
