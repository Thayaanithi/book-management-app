package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	private long id;
	private String title;
	private String author;
	private String category;

	private Member member;

	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@ManyToOne
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book(long id, String title, String author, String category, Member member) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.member = member;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}