package com.babel.rent.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.naming.NamingException;
import javax.xml.ws.BindingProvider;

import org.junit.Before;
import org.junit.Test;

import com.babel.rent.test.ws.port.RentWS;
import com.babel.rent.test.ws.port.RentWSService;


public class TestRentWS {

	RentWS rentServiceDelegate;
	
	@Before
	public void init() throws NamingException{
		RentWSService proxy=new RentWSService();
		rentServiceDelegate=proxy.getRentWSPort();
		((BindingProvider)rentServiceDelegate).getRequestContext().put(BindingProvider.
	            ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/rent-ws/Rent");
	}
	@Test
	public void testService(){
		com.babel.rent.test.ws.port.Rent rent=this.rentServiceDelegate.readRent(7L);
		//for strange errors with jboss AS
		//https://issues.jboss.org/browse/JBWS-2418
		assertNotNull("Rent not found",rent);
				
		rent.setNotes("testing update"+new Date().getTime());
		com.babel.rent.test.ws.port.Rent updatedRent=this.rentServiceDelegate.saveRent(rent);
		assertNotNull("Updated Rent not coming back", updatedRent);
		//this assertion is going to fail when RentWS is workign with the RentWSFactory
		//@see RentWS constructor comment!!!
		assertTrue("Entity version should have changed +1 but it did not",
				rent.getVersion().equals(updatedRent.getVersion() - 1));
		
		
	}
}
