package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링에서 구성(설정) 정보를 담당하는 파일
public class AppConfig { // 어플리케이션 전체를 설정 (어플리케이션 전체의 역할이 보이는게 좋음)

    // 클라이언트는 어떤 클래스에 의존하는지 신경쓰지 않아도 됨
    // 전체 설정 파일인 AppConfig에서 DI
    // 메서드만 봐도 역할들이 드러나게 구성해주는게 좋음

    @Bean // 스프링 컨테이너에 등록
    public MemberService memberService() {
        // 생성자를 통해 객체를 생성
        return new MemberServiceImpl(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository() { // 멤버 리포지토리 역할
        return new MemoryMemberRepository(); // 구현: 리포지토리가 바껴도 여기만 바꾸면 OK
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy() { // 할인 정책 역할
        // 구성 영역과 사용 영역으로 나눠 할인 정책 변경 시 여기만 수정하면 OK
        return new RateDiscountPolicy();
    }


}
