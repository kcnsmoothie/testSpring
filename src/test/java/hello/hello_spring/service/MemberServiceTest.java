package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    //테스트 코드같은 경우는 한국어로 써도 됨. 빌드 시에 포함 안되니까요

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName();

        //when

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}