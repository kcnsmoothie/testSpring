package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    //requried = false로 하면 값을 반드시 안 넘겨도 됨
    // true면 ?name=spring 같이 넘겨줘야함
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //view 이딴 거 없이 문자가 그대로 내려감
    @GetMapping("hello-string")
    @ResponseBody //http에서 body 부분에 이 응답을 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    //GDGoC API 1번
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
