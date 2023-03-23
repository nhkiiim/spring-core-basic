package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    /*@Test
    @DisplayName("수정자 주입 테스트")
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        // createOrder만 테스트 하는 단위 테스트 임에도 set 해줘야 테스트 가능 (NPE 발생)
        orderService.setMemberRepository(new MemoryMemberRepository());
        orderService.setDiscountRepository(new FixDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);
    }*/

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new FixDiscountPolicy(), memberRepository);
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}