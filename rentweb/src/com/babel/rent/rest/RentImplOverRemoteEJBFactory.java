package com.babel.rent.rest;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.babel.rent.CreateRent;
import com.babel.rent.ReadRent;
import com.babel.rent.SaveRent;

public class RentImplOverRemoteEJBFactory extends RentImplFactory {

	private String ejbInterface = "remote";

	/**
	 * 
	 * @param ejbInterface
	 *            = remote / local depending on deployment context
	 *            
	 * Excelent post about JNDI names generated for JBoss AS 4.2
	 * https://developer.jboss.org/thread/121194 
	 * (see Answer 6 - jmx-console)
	 * http://localhost:8080/jmx-console/ -->service=JNDIView -->list() invoke
	 */
	protected RentImplOverRemoteEJBFactory(String ejbInterface) {
		this.ejbInterface = ejbInterface;
	}

	protected RentImplOverRemoteEJBFactory() {
	}

	@Override
	public CreateRent createRentFactory() {
		try {
			System.out.println("CreateRent Factory provides " + ejbInterface
					+ " EJB interface");
			return (CreateRent) new InitialContext()
					.lookup("rentEAR(order-ear)/CreateRentEJB/" + ejbInterface);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public ReadRent readRentFactory() {
		try {
			System.out.println("ReadRent Factory provides " + ejbInterface
					+ " EJB interface");
			return (ReadRent) new InitialContext()
					.lookup("rebtEAR(rent-ear)/ReadRentEJB/" + ejbInterface);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public SaveRent saveRentFactory() {
		try {
			System.out.println("SaveRent Factory provides " + ejbInterface
					+ " EJB interface");
			return (SaveRent) new InitialContext()
					.lookup("rentEAR(rent-ear)/SaveRentEJB/" + ejbInterface);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
