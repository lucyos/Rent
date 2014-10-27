package com.babel.rent.socket.test;

import org.junit.Before;
import org.junit.Test;

import com.babel.rent.socket.CreateCSVRent;
import com.babel.rent.socket.RentSocketFactory;


public class CreateCSVRentTest {

	CreateCSVRent createCSVRentWorker;

	@Before
	public void init() {
		createCSVRentWorker = RentSocketFactory.createCSVRentFactory();

	}

	@Test
	public void test1() {
		String msg = buildNewRentCSVText();
		createCSVRentWorker.createCSVRent(msg);
		//Expecting just to execute successfully
		

	}

	public static String buildNewRentCSVText() {
		StringBuilder msgBuilder = new StringBuilder().append("Customer 1")
				.append("\n").append("customer1@gmail.com").append("\n")
				.append("customer1 address").append("\n")
				.append("item1, 2, 100").append("\n").append("item2, 10, 25").append("\n");
		return msgBuilder.toString();
	}

}
