package com.babel.rent;

import com.babel.core.function.crud.Create;


public interface CreateRent extends Create {

	/**
	 * 
	 * @param p
	 */
	public Rent createRent(Rent p);

}