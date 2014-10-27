package com.babel.rent;

import com.babel.core.function.crud.Update;

public interface SaveRent extends Update {

	/**
	 * 
	 * @param p
	 */
	public Rent saveRent(Rent p);

}