package com.babel.rent;

import com.babel.core.function.crud.ReadById;

public interface ReadRent extends ReadById {

	/**
	 * 
	 * @param p
	 */
	public Rent readRent(Long p);

}