package hello.hello_spring.domain;

public class Member {

    private Long id; //id 식별자 : DB 저장용 임의의 system값
    private String name; //사용자


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
