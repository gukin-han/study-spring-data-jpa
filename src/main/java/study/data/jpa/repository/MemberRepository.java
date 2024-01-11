package study.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.data.jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
