package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("sprfing");

        repository.save(member);

        //optional에서 꺼내는 거니까 get으로 꺼내볼 수도 있음
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result =));
    }
}
