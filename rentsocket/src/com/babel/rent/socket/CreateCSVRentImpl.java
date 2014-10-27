package com.babel.rent.socket;

import com.babel.rent.CreateRent;
import com.babel.rent.Rent;
import com.babel.rent.RentLine;

public class CreateCSVRentImpl implements CreateCSVRent {

	private CreateRent createRentDelegate;

	public CreateCSVRentImpl(CreateRent delegate) {
		createRentDelegate = delegate;

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param p
	 *            - expecting CSV String implementing the CreateOrder from CSV
	 *            protocol
	 */
	public String createCSVRent(String p) {
		Rent rent = new Rent();
		try {
			String[] lines = p.split("\n");
			// first line should contain customer's name
			rent.setClientName(lines[0]);
			// second line should contain the email address
			rent.setClientEmail(lines[1]);
			// third line should contain the delivery address
			rent.setClientAddress(lines[2]);
			// next lines should contain the items
			RentLine l = null;
			String[] line = null;
			for (int i = 3; i < lines.length; i++) {
				line = lines[i].split(", ");
				l = new RentLine();
				l.setCarModel(line[0]);
				l.setQuantity(Double.valueOf(line[1]));
				l.setPrice(Double.valueOf(line[2]));
				rent.addRentLine(l);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RuntimeException(
					"Error! Code 400 - Bad Request:Invalid format! "
							+ t.getMessage());

		}

		try {
			Rent nRent = this.getCreateRentDelegate().createRent(rent);
			// If everything ok return some unique reference for future
			// identification of the new order.
			// Just for this simple test, we return the id, though not really
			// recommended in real life situations.
			return nRent.getId().toString();
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RuntimeException("Error! Code 500: Internal Server Error! ");
		}

	}

	public CreateRent getCreateRentDelegate() {
		return createRentDelegate;
	}

	public void setCreateRentDelegate(CreateRent createRentDelegate) {
		this.createRentDelegate = createRentDelegate;
	}

}// end CreateCSVRentImpl