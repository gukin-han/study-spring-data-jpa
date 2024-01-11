package study.data.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue // auto sequence
    private Long id;
    private String name;

    protected Member() { // jpa라서 기본 생성자를 필요하고(적어도 private) -> proxing을 사용하기 때문
        // + 함부로 생성하지 못하도록 protected
    }

    public Member(String name) {
        this.name = name;
    }
}
