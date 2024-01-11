package study.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.data.jpa.entity.Team;

// 리파지토리 애노테이션 생략 가능
public interface TeamRepository extends JpaRepository<Team, Long> {
}
