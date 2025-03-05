package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Author;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.repos.AuthorRepo;
import com.valtech.training.first.repos.BookRepo;
import com.valtech.training.first.repos.PublisherRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookStoreServiceImpl implements BookStoreService {
	
	@Autowired
	private PublisherRepo publisherRepo;
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private AuthorRepo authorRepo;
	
	@Override
	public long countAllBooks()	{
		return bookRepo.count();
	}
	
	@Override
	public long countAllAuthors()	{
		return authorRepo.count();
	}
	
	@Override
	public long countAllPublishers()	{
		return publisherRepo.count();
	}
	@Override
	public List<Book> getAllBooks()	{
		return bookRepo.findAll();
	}
	
	@Override
	public List<Author> getAllAuthors()	{
		return authorRepo.findAll();
	}
	
	@Override
	public List<Publisher> getAllPublishers()	{
		return publisherRepo.findAll();
	}

	@Override
	public List<Book> getBooksByYearBetween(int i, int j) {
		return bookRepo.findAllByYearBetween(i, j);
	}

	@Override
	public List<Book> getBooksByPriceGreaterThan(int i) {
		return bookRepo.findAllByPriceGreaterThan(i);
	}
	
	public List<Integer> findAllPriceByAuthorsId(long id)	{
		return bookRepo.findAllPriceByAuthorsId(id);
	}
	
	public List<BookInfoDTO> getBookInfoByAuthor(long id)	{
		return bookRepo.getBookInfoByAuthor(id);
	}

}
