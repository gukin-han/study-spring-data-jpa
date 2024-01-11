package study.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.data.jpa.dto.MemberDto;
import study.data.jpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    List<Member> findTop3HelloBy();

    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    @Query("""
            select m.username
            from Member m
            """)
    List<String> findUsernameList();

    @Query("""
            select new study.data.jpa.dto.MemberDto(m.id, m.username, t.name) 
            from Member m 
            join m.team t
            """)
    List<MemberDto> findMemberDto();
}
