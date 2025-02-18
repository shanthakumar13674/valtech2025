package com.valtech.training.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ArithmeticImplTest {
	
	private Arithmetic arithmetic;
	
	@BeforeAll
	public static void asdasd()	{
		System.out.println("Before All....");
	}
	
	@BeforeEach
	public void some()	{
		System.out.println("Init....");
		arithmetic = new ArithmeticImpl();
	}
	
	@ParameterizedTest(name = "Add with Multiple Values")
	@ValueSource(strings = {"5,2,3","4,2,2","0,3,-3"})
	void testAddAgain(String param) { // "5,2,3","4,2,2","0,3,-3"
		List<Integer> args = Arrays.asList(param.split(",")).stream().map(it -> Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(args.get(0),arithmetic.add(args.get(1), args.get(2)));
	}

	@Test()
	void testAdd() {
		System.out.println("Add....");
		assertEquals(5,arithmetic.add(2, 3));
	}
	
	
	@Test()
	void testSub() {
		System.out.println("Sub....");
		assertEquals(5,arithmetic.sub(8, 3));
	}

}
