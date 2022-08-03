package com.example.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Member;
import com.example.service.MemberService;

@RestController
@RequestMapping(value = "/member")
public class MemberController {
	public MemberService service;
	
	public MemberController(MemberService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Member create(@RequestBody Member member) {
		return this.service.addMember(member);
	
		
	}

	@GetMapping("/read")
	public void read() {

	}

	@PutMapping("/update")
	public void update() {

	}

	@DeleteMapping("/delete")
	public void delete() {

	}

	@GetMapping("/readOne")
	public void readOne() {

	}

	@GetMapping("/login/{userName}/{password}")
	public int login(@PathVariable String userName, @PathVariable String password) {
		return this.service.checkCredentials(userName, password);
	}

}
