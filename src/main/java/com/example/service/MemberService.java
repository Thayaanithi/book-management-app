package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.MemberDTO;
import com.example.model.Member;
import com.example.repo.MemberRepo;

@Service
public class MemberService {
	@Autowired
	private MemberRepo repo;
	@Autowired
	private ModelMapper mapper;

	public MemberService(MemberRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private MemberDTO mapToDTO(Member member) {
		return this.mapper.map(member, MemberDTO.class);
	}

	public MemberDTO addMember(Member member) {
		Member saved = this.repo.save(member);
		return mapToDTO(saved);

			// return this.repo(saved);
	}

	public List<MemberDTO> getAllMember() {
		return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
		// return this.repo.findAll();

	}

	public int checkCredentials(String userName, String password) {
		int flag = 0;
		if (!repo.login(userName, password).isEmpty()) {
			flag = 1;
			System.out.println("Inside " + flag);
			return flag;
		}
		System.out.println("out --" + flag);
		return flag;
	}

	public MemberDTO updateMember(long id, Member member) {
		Optional<Member> existingOptional = repo.findById(id);
		Member existing = existingOptional.get();

		existing.setUserName(member.getUserName());
		existing.setPassword(member.getPassword());
		existing.setName(member.getName());
		existing.setAddress(member.getAddress());
		existing.setEmail(member.getEmail());
		existing.setContactNo(member.getContactNo());
		Member updated = this.repo.save(existing);
		return this.mapToDTO(updated);

	}

	public boolean deleteMember(Long id) {
		repo.deleteById(id);
		boolean exists = repo.existsById(id);
		return !exists;

	}
}