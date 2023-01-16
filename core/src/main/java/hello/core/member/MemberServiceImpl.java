package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;    //DIP(추상화에 의존해야지 구체화에 의존하면 안된다) 위반

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
