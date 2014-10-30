package com.rent.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.babel.rent.CreateRent;
import com.babel.rent.Rent;
import com.babel.rent.ReadRent;
import com.babel.rent.SaveRent;

public class TestRentEJB {

	private static final String TESTING_UPDATE = "testing update"
			+ Calendar.getInstance().getTimeInMillis();
	private static final long RENT_ID = 4L;
	CreateRent createRentService;
	SaveRent saveRentService;
	ReadRent readRentService;

	@Before
	public void init() throws NamingException {
		// lookup needs a JNDI name.
		// With JBoss AS 4.x, the default naming is EARFileName/ejb name/remote
		// (for remote access)
		readRentService = (ReadRent) new InitialContext()
				.lookup("rentEAR/ReadRentEJB/remote");
		saveRentService = (SaveRent) new InitialContext()
				.lookup("rentEAR/SaveRentEJB/remote");
	}

	/**
	 * Note: "javax.naming.NoInitialContextException:Cannot instantiate class
	 * org.jnp.interfaces.Naming..." may appear on first attempt to run this
	 * test. This may happen because there is no entry in pom for the app
	 * server-specific dependencies (e.g JBoss). The easiest way to fix it is to
	 * associate the project with the server runtime:
	 * Eclipse/rent-process-ejb/properties/runtime environments/check the
	 * server you deploy on
	 */
	@Test
	public void testReadUpdate() {
		Rent rent = this.readRentService.readRent(RENT_ID);
		assertNotNull("Rent not found", rent);
		rent.setNotes(TESTING_UPDATE);
		Rent updatedRent = this.saveRentService.saveRent(rent);
		assertNotNull("Updated Rent not coming back", updatedRent);
		assertTrue("Entity version should have changed +1 but it did not",
				rent.getVersion().equals(updatedRent.getVersion() - 1));
		Rent dbRent = this.readRentService.readRent(RENT_ID);
		assertTrue("the new field value not commited in DB",
				TESTING_UPDATE.equals(dbRent.getNotes()));

		assertTrue(
				"Entity version in the DB " + dbRent.getVersion()
						+ " not the same as update return "
						+ updatedRent.getVersion(), dbRent.getVersion()
						.equals(updatedRent.getVersion()));

	}

	/**
	 * Expecting an exception here.
	 */
	@Test
	public void testNullParams() {
		Throwable expectedException = null;
		try {
			this.saveRentService.saveRent(null);
		} catch (Throwable e) {
			e.printStackTrace();
			// all serverside exceptions are wrapped around EJBException
			// so, get the real one (the cause)
			expectedException = e.getCause();
		}
		assertNotNull("Expecting exception here. None received!",
				expectedException);
		assertTrue(
				"An IllegalArgumentException expected."
						+ expectedException.getClass() + " received instead",
				expectedException.getClass().equals(
						IllegalArgumentException.class));

	}
}
