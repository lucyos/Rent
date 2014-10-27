package com.babel.rent;

import com.babel.core.function.crud.UpdateImpl;

public class SaveRentImpl extends UpdateImpl implements SaveRent {

	public SaveRentImpl() {

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param p
	 */
	public Rent saveRent(Rent p) {
		return super.update(p);
	}
}// end SaveRentImpl