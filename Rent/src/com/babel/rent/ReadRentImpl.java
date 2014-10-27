package com.babel.rent;

import com.babel.core.function.crud.ReadByIdImpl;

public class ReadRentImpl extends ReadByIdImpl implements ReadRent {

	public ReadRentImpl() {

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param p
	 */
	public Rent readRent(Long p) {
		return super.readById(Rent.class, p);
	}
}// end ReadRentImpl