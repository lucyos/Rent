package com.babel.rent.ws;

import javax.persistence.Persistence;

import com.babel.rent.CreateRent;
import com.babel.rent.CreateRentImpl;
import com.babel.rent.ReadRent;
import com.babel.rent.ReadRentImpl;
import com.babel.rent.SaveRent;
import com.babel.rent.SaveRentImpl;

public class RentImplFactory {
	
	/**This implementation is working with a RESOURCE-LOCAL EM configuration
	but there is no container-managed transactions.
	As a consequence, you have to manage transactions manually (e.g. implement Chain-of-Responsibilities design pattern to begin/commit transaction)
	**/
	private javax.persistence.EntityManager em = null;
//			Persistence
//			.createEntityManagerFactory("myJPAUnitRentWS")
//			.createEntityManager();
	//static private RentWSFactory f = new RentWSFactory();
	/**
	 * Use the EJB implementation for the requred delegates.
	 * This one is for remote EJBs (when .war is deployed standalone
	 * 
	 */
	static private RentImplFactory f = new RentImplOverRemoteEJBFactory();
	
	/**
	 * Use the EJB implementation for the requred delegates.
	 * This one is for local EJBs (when .war is deployed wityhin the same .ear as the ejb)
	 * This should be the most optimal approach (@see remote vs local EJBs)
	 */
	//static private RentImplFactory f = new RentImplOverLocalEJBFactory();
	
	protected RentImplFactory() {

	}

	public static RentImplFactory getInstance() {
		return f;
	}

	public CreateRent createRentFactory() {
		CreateRentImpl delegate = new CreateRentImpl();
		delegate.setEm(em);
		return delegate;
	}

	public ReadRent readRentFactory() {
		ReadRentImpl delegate = new ReadRentImpl();
		delegate.setEm(em);
		return delegate;
	}
	
	public SaveRent saveRentFactory() {
		SaveRentImpl delegate = new SaveRentImpl();
		delegate.setEm(em);
		return delegate;
	}
}
