package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//test 케이스의 장점 : class 단위로 돌려볼 수 있음
public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //optional에서 꺼내는 거니까 get으로 꺼내볼 수도 있음
        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = " + (result = member));
        //위의 코드를 매번 문자로 확인 안해도 되도록 도와주는 도구
        //Assertions.assertEquals(member, null);
        //alt + enter -> static import
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member member = repository.findByName("spring1").get();
        assertThat(member).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> all = repository.findAll();


    }
}
