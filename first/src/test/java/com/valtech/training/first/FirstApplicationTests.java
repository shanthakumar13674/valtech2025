package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.BookStoreService;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
//@Transactional(propagation = Propagation.REQUIRED)
class FirstApplicationTests {
	
	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired 
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private BookStoreService bookStoreService;
	
	@Test
	void testBookStore()	{
		assertEquals(3, bookStoreService.countAllPublishers());
		assertEquals(6,bookStoreService.countAllBooks());
		assertEquals(6,bookStoreService.countAllAuthors());
		assertEquals(5, bookStoreService.getBooksByYearBetween(2000,2006).size());
		assertEquals(3,bookStoreService.getBooksByPriceGreaterThan(100).size());
		assertEquals(2,bookStoreService.findAllPriceByAuthorsId(1).size());
		System.err.println(bookStoreService.findAllPriceByAuthorsId(1));
		System.err.println(bookStoreService.getBookInfoByAuthor(2));
	}

	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200, 5, 20));
	}

	@Test
//	@Rollback()
	void questionService()	{
		initData();
		assertEquals(6, questionService.countByTopic("GK"));
		assertEquals(6, questionService.countByTopic("Java"));
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("Java","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("Java","interface"));
		assertEquals(5, questionService.findAllByTopic("GK", 0, 5).size());
		assertEquals(1, questionService.findAllByTopic("GK", 1, 5).size());
	}
	
	void initData()	{
		Question q = questionService.saveQuestion
		(new Question("What is the color of Sky?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion
		(new Question("What is the color of Mars?","Red","Blue","Green","White","Red","GK"));
		questionService.saveQuestion
		(new Question("What is the color of Moon?","Red","Blue","Green","White","White","GK"));
		questionService.saveQuestion
		(new Question("What is the color of Jupiter?","Red","Blue","Green","Yellow","Yellow","GK"));
		questionService.saveQuestion
		(new Question("What is the color of Saturn?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion
		(new Question("What is the color of Venus?","Red","Blue","Green","White","White","GK"));
		
		questionService.saveQuestion
		(new Question("What is the Super Class of Exceptions?","Object","Exception","Throwable","Error","Throwable","Java"));
		questionService.saveQuestion
		(new Question("Which class is used to create Dynamic Strings?"
				,"String","DynamicString","StringBuilder","Builder","StringBuilder","Java"));
		questionService.saveQuestion
		(new Question("How many methods are there in Marker Interface?"
				,"None","One","Two","Many","None","Java"));
		questionService.saveQuestion
		(new Question("How many methods are Functional Interface?"
				,"None","One","Two","Many","One","Java"));
		questionService.saveQuestion
		(new Question("Can an Interface have private methods?"
				,"Yes","No","May be","No methods can be there in an interface","Yes","Java"));
		questionService.saveQuestion
		(new Question("Which subclass of Exception is not checked by the Compiler?"
				,"Exception","Error","RuntimeException","None","RuntimeException","Java"));
	}
}










