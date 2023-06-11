package hello.core.order;

public interface OrderService {
    /**
     * 1번 주문생성
     * 회원 ID, 상품명, 상품 가격 요구
     * @return 주문결과 반환
     * **/
    Order createOrder(Long memberId,String itemName,int itemPrice);
}
