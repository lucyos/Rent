package com.rent.ejb.test;

import static org.junit.Assert.assertFalse;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.babel.rent.LoadRentsBatch;
import com.babel.rent.Rent;
import com.babel.rent.RentsBatchException;

public class TestLoadRentsBatch {

	LoadRentsBatch worker;

	@Before
	public void init() throws NamingException {

		worker = (LoadRentsBatch) new InitialContext()
				.lookup("rentEAR/LoadRentsBatchEJB/remote");

	}

	@Test
	public void test() {
		List<Rent> rentsLst = new LinkedList<Rent>();
		Rent rent = new Rent();
		rent.setClientName("Batch 1");
		rent.setClientEmail("Batch1@yahoo.com");
		rentsLst.add(rent);
		rentsLst.add(null); // this should fail ...IllegalArgumentException (is
								// a RuntimeException, so it will rollback) -
								// see NullParamValidator interceptor on
								// CreateRentEJB
		rent = new Rent();
		rent.setClientName("Batch 2");
		rent.setClientEmail("Batch2@yahoo.com");
		rentsLst.add(rent);

		try {
			this.worker.loadRentsBatch(rentsLst);
		} catch (Throwable e) {
			e.printStackTrace();
			if ((e instanceof RentsBatchException)
					|| (e.getCause() instanceof IllegalArgumentException)) {
				e.printStackTrace();
				return;
			}
		}
		assertFalse("should not arrive here...", 1 == 1);
	}

}
