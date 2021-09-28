package com.example.junit.demo;

import MathStuff.MathStuff;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class JunitDemoApplicationTests {

	/*
	 * When a number is positive, the method isPositive() should return true.
	 */
	@Test
	void testPositive() {
		MathStuff mathStuff = new MathStuff();
		assertTrue(mathStuff.isPositive(5));
	}

	/*
	 * When a number is negative, the method isPositive() should return false.
	 */
	@Test
	void testNegative() {
		MathStuff mathStuff = new MathStuff();
		assertFalse(mathStuff.isPositive(-5));
	}

	/*
	 * The method add() returns the sum of two numbers
	 */
	@Test
	void testAdd() {
		MathStuff mathStuff = new MathStuff();
		int expected = 2;
		int value = mathStuff.add(1, 1);
		assertEquals(expected, value);
	}

	/*
	 * The method divide() returns the quotient after dividing two numbers
	 */
	@Test
	void testDivision() {
		MathStuff mathStuff = new MathStuff();
		double expected = 2.0;
		double value = Double.parseDouble(mathStuff.divide(4, 2));
		assertEquals(expected, value);
	}

	/*
	 * If the divisor is equal to zero, then the method() returns a message
	 */
	@Test
	void testDivideByZero() {
		MathStuff mathStuff = new MathStuff();
		String expected = "Cannot be divided";
		String value = mathStuff.divide(4, 0);
		assertEquals(expected, value);
	}

}
