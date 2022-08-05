package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.BookDTO;
import com.example.model.Book;
import com.example.repo.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo repo;
	@Autowired
	private ModelMapper mapper;
	
	
	public BookService() {
		super();
		
	}

	

	
	private BookDTO mapToDTO(Book book) {
		return mapper.map(book, BookDTO.class);
	}
	public BookDTO addBook(Book book) {
		Book saved = repo.save(book);
		return mapToDTO(saved);
		//Book saved = repo.save(book);
		//return mapToDTO(saved);
	}
	public List<BookDTO> getAllBook(){
		
		return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public BookDTO updateBook(long id, Book book) {
		Optional<Book> existingOptional = repo.findById(id);
		Book existing = existingOptional.get();
		
		existing.setTitle(book.getTitle());
		existing.setAuthor(book.getAuthor());
		existing.setCategory(book.getCategory());
		Book updated = repo.save(existing);
		return mapToDTO(updated);
	}
	
	public boolean deleteBook (long id) {
		repo.deleteById(id);
		boolean exists = repo.existsById(id);
		return !exists;
	}
}

