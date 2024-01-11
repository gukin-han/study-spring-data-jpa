package study.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"}) // 연관관계에 있는 것은 하지말것
public class Member {

    @Id
    @GeneratedValue // auto sequence
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY) // 외부에서 멤버 리스트를 불러오면 각각의 팀도 각각 쿼리하는 것을 방지
    @JoinColumn(name = "team_id") // FK 이름
    private Team team;

//    protected Member() { // jpa라서 기본 생성자를 필요하고(적어도 private) -> proxing을 사용하기 때문
//        // + 함부로 생성하지 못하도록 protected
//    }

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;

        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team; // DB 관점에서는 FK 변경
        team.getMembers().add(this); // 연관관계 세팅
        // TX내에서 로직을 작성할때
        // persist를 commit 하기 전이기 때문에
        // 비즈니스 로직을 작성하는 경우 에러가 생길 확률이 높다

        // 참고로 원칙적으로는 이전 팀에서 멤버를 제거하는게 맞지만
        //
    }
}
