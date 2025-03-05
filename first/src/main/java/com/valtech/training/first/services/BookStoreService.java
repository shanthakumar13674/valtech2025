package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Author;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Publisher;

public interface BookStoreService {

	long countAllBooks();

	long countAllAuthors();

	long countAllPublishers();

	List<Book> getAllBooks();

	List<Author> getAllAuthors();

	List<Publisher> getAllPublishers();

	List<Book> getBooksByYearBetween(int i, int j);

	List<Book> getBooksByPriceGreaterThan(int i);
	
	List<Integer> findAllPriceByAuthorsId(long id);
	
	List<BookInfoDTO> getBookInfoByAuthor(long id);

}