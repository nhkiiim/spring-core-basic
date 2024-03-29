package hello.core.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

/*

    // 생성자 주입으로 구체적인 클래스에 의존하지 않음 (DIP OK)
    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired // setter 주입
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired // 필드 주입
    private MemberRepository memberRepository;

    @Autowired // 일반 메서드 주입
    public void init(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

*/

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
