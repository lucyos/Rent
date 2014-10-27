package com.babel.rent;

import java.util.LinkedList;
import java.util.List;

public class LoadRentsBatchImpl implements LoadRentsBatch {

	private CreateRent createRent;

	public LoadRentsBatchImpl() {
	}

	public LoadRentsBatchImpl(CreateRent c) {
		this.createRent = c;
	}

	@Override
	public void loadRentsBatch(List<Rent> rents) throws RentsBatchException {
		RentsBatchException errors = null;
		for (Rent rent : rents) {
			System.out.println("processing rent - " + rent);
			try {
				createRent.createRent(rent);
			} catch (Throwable t) {
				if (errors == null)
					errors = new RentsBatchException();
				errors.addRentInError(rent);
				t.printStackTrace();
			}
		}
		if (errors != null)
			throw errors;

	}

	public CreateRent getCreateRent() {
		return createRent;
	}

	public void setCreateRent(CreateRent createRent) {
		this.createRent = createRent;
	}

}
