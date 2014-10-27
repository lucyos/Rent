package com.babel.rent.socket;

import javax.persistence.Persistence;

import com.babel.rent.CreateRentLocalJPA;

public class RentSocketFactory {

	public static CreateCSVRent createCSVRentFactory() {
		CreateRentLocalJPA x = new CreateRentLocalJPA();
		x.setEm(Persistence.createEntityManagerFactory("BabelConnRentSocket")
				.createEntityManager());
		
		
		return new CreateCSVRentImpl(x);
	}
}
