package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*회원 가입 : Member 레포에 save를 호출해서 저장*/
    public Long join(Member member) {
        //같은 이름이 있다면 중복 저장 X
        //Optional<Member> result = memberRepository.findByName(member.getName());
        //기존에는 ifNull을 했겠지만, Optional로 감쌌으니까 ifPresent를 사용해도 됨.
        //값이 없으면 orElseGet을 사용해볼 수도 있음
        validateDuplicateMember(member, memberRepository);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member, MemberRepository memberRepository) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
