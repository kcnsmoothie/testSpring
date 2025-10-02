package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //스프링 컨테이너에 등록해놓고 사용하기
    private final MemberService memberService;

    @Autowired //스프링 컨테이너에 있는 MemberService와 연결해주는 애노테이션
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
