package com.babel.rent;

import java.util.List;

public interface LoadRentsBatch {

	public void loadRentsBatch(List<Rent> rents)
			throws RentsBatchException;

}
