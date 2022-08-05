package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookDTO;
import com.example.model.Book;
import com.example.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	private BookService service;

	public BookController(BookService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public BookDTO addBook(@RequestBody Book book) {
		return this.service.addBook(book);
	}

	@GetMapping("/read")
	public List<BookDTO> read() {
		return this.service.getAllBook();
	}

	@PutMapping("/update/{id}")
	public BookDTO update(@PathVariable long id, @RequestBody Book book) {
		return this.service.updateBook(id, book);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) {
		this.service.deleteBook(id);
	}

	// this.service.deleteMember(id);

//	@GetMapping("/readOne")
//	public List<BookDTO>readOne() {
//		return this.service.getOneBook();
//	}


}
