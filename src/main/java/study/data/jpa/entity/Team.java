package study.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") // FK가 없는 쪽에 권장
    // 리스트는 연관관계의 주인이 아니기 때문에 실제 DB에 영향x
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}
