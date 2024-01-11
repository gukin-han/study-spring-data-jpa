package study.data.jpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.data.jpa.entity.Member;

import static org.junit.jupiter.api.Assertions.*; // junit 5 == jupiter

@SpringBootTest // 스프링 컨테이너가 필요하기 때문 (junit5 + spring boot)
@Transactional // 클래스 레벨로 달면 메서드에 모두 적용
@Rollback(value = false)
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() {
        Member member = new Member("memberA"); // 생성자로 만드는게 가장 좋다
        Member savedMember = memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.find(savedMember.getId());
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }

}