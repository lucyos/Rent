package com.babel.rent;

import com.babel.core.function.crud.CreateImpl;

public class CreateRentImpl extends CreateImpl implements CreateRent {

	public CreateRentImpl() {

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param p
	 */
	public Rent createRent(Rent p) {
		return super.create(p);
	}
}// end CreateRentImpl