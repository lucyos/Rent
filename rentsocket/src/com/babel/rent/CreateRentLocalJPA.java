package com.babel.rent;

import com.babel.rent.CreateRentImpl;
import com.babel.rent.Rent;

public class CreateRentLocalJPA extends CreateRentImpl {

	
	

	public CreateRentLocalJPA() {

	}

	
	/**
	 * 
	 * @param p
	 */
	public Rent createRent(Rent p) {
		this.getEm().getTransaction().begin();
		Rent r=super.createRent(p);
		this.getEm().getTransaction().commit();
		return r;
	}

	
}// end CreateRentEJB