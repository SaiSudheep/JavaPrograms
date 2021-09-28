package com.example.rest.demo;

import com.example.rest.demo.model.Fruit;
import com.example.rest.demo.services.Dummy;
import com.example.rest.demo.services.FruitServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class RestDemoApplicationTests {

	@Mock
	Dummy dummy;

	@InjectMocks
	FruitServiceImpl service;

	/*
	 * The getList() method returns the list of fruits
	 */
	@Test
	void testGetFruits() {
		//
		// Given
		//
		int expected = 2;

		//
		// When
		//
		when(dummy.getList()).thenReturn(expectedList());

		//
		// Then
		//
		assertEquals(expected, dummy.getList().size());
		verify(dummy, times(1)).getList();
	}

	private List<Fruit> expectedList() {
		List<Fruit> list = new ArrayList<>();
		list.add(new Fruit(1,"Mango", 10));
		list.add(new Fruit(2,"Pear", 50));

		return list;
	}

}
