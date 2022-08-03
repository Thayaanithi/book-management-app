package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.model.Member;

@Repository
@EnableJpaRepositories
public interface MemberRepo extends JpaRepository<Member, Long> {
	@Query("SELECT m from Member m WHERE m.userName =?1 and m.password=?2")
	List<Member> login(String userName, String password);

}
