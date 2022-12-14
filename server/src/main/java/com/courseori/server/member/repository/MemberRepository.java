package com.courseori.server.member.repository;

import com.courseori.server.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByUsername(String member);
}
