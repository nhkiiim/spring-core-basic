package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig { // 어플리케이션 전체를 설정

    // 클라이언트는 어떤 클래스에 의존하는지 신경쓰지 않아도 됨
    // 전체 설정 파일인 AppConfig에서 DI

    public MemberService memberService() {
        // 생성자를 통해 객체를 생성
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new FixDiscountPolicy(),new MemoryMemberRepository());
    }


}
