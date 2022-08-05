package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MemberDTO;
import com.example.model.Member;
import com.example.service.MemberService;

@RestController
@RequestMapping(value = "/member")
public class MemberController {
	@Autowired
	public MemberService service;
	
	public MemberController(MemberService service) {
		super();	
		this.service = service;
	}

	@PostMapping("/create")
	public MemberDTO addMember(@RequestBody Member member) {
		return this.service.addMember(member);
		//return this.addMember(member);
			
	}
	
	@GetMapping("/read")
	public List<MemberDTO> read() {
return this.service.getAllMember();
		//service.getAllMember();
	}

	@PutMapping("/update/{id}")
	public MemberDTO update(@PathVariable long id, @RequestBody Member member){
		return this.service.updateMember(id, member);
		}
		
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
			this.service.deleteMember(id);
	}

	/*@GetMapping("/member/{name}")
	public MemeberDTO memberByName(@PathVariable String name) {
		return this.service.getByName(name);*/
	

	@GetMapping("/login/{userName}/{password}")
	public int login(@PathVariable String userName, @PathVariable String password) {
		return this.service.checkCredentials(userName, password);
	}

}
