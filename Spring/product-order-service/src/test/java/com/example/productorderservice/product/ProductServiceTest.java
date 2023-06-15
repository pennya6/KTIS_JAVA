package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductServiceTest {
    private ProductService productService;

    @BeforeEach
    void setUp(){
        productService=new ProductService();
    }

    @Test
    void 상품등록(){
        final String name="상품명";
        final int price=1000;
        final DiscountPolicy discountPolicy=DiscountPolicy.NONE;
        final AddProductRequest request=new AddProductRequest(name,price,discountPolicy);
        productService.addProduct(request);
    }
    private record AddProductRequest( String name,  int price, DiscountPolicy discountPolicy){
            private AddProductRequest{
                Assert.hasText(name,"상품명은 필수입니다.");
                Assert.isTrue(price>0,"상품가격은 0보다 커야합니다.");
                Assert.notNull(discountPolicy,"할인정책은 필수입니다.");
            }
    }
    private enum DiscountPolicy{
        NONE
    }

    private class ProductService {
        private ProductPort productPort;

        public void addProduct(final AddProductRequest request) {
            final Product product=new Product(request.name(),request.price(),request.discountPolicy());
            productPort.save(product);
        }
    }

    private class Product {
        private final String name;
        private final int price;
        private final DiscountPolicy discountPolicy;
        public Product(final String name,final int price,final DiscountPolicy discountPolicy) {
            Assert.hasText(name,"상품명은 필수입니다.");
            Assert.isTrue(price>0,"상품가격은 0보다 커야합니다.");
            Assert.notNull(discountPolicy,"할인정책은 필수입니다.");

            this.name=name;
            this.price=price;
            this.discountPolicy=discountPolicy;
        }
    }

    private class ProductPort {
    }
}
