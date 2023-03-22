package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 학습하며 만들어둔 Configuration 필터링
) // @Component 애너테이션을 찾아가 자동으로 컨테이너에 등록해줌
@Configuration
public class AutoAppConfig {

    @Autowired
    MemberRepository memberRepository;
    @Autowired // Configuration 클래스에서는 필드 주입 사용하기도 함
    DiscountPolicy discountPolicy;
/*

    // 자동으로 등록되는 빈이랑 같은 이름으로 하나 생성 (테스트용)
    // Overriding bean definition
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

*/
}
