package hello.core;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 스프링 띄우는 테스트 (@Test는 자바단에서 가능)
class CoreApplicationTests {

	@Autowired // 테스트 코드는 누가 가져다 쓸 일이 없으니까 필드 주입 OK
	MemberService memberService;

	@Test
	void contextLoads() {
	}

}
