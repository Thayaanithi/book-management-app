package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Member;
import com.example.repo.MemberRepo;

@Service
public class MemberService {
	@Autowired
	public MemberRepo repo;

	public Member addMember(Member member) 
	{
		return this.repo.save(member);
	}

	public List<Member> getAllMember() {
		return this.repo.findAll();

	}

	public int checkCredentials(String userName, String password) 
	{
		int flag = 0;
		if (!repo.login(userName, password).isEmpty()) 
		{
			flag = 1;
			System.out.println("Inside "+flag);
			return flag;
		}
		System.out.println("out --"+flag);
		return flag;
	}
}
