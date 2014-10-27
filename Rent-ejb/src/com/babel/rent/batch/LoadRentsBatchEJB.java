package com.babel.rent.batch;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.babel.rent.LoadRentsBatch;
import com.babel.rent.LoadRentsBatchImpl;
import com.babel.rent.Rent;
import com.babel.rent.RentsBatchException;

@javax.ejb.Stateless
@javax.ejb.Remote(value = LoadRentsBatch.class)
@javax.ejb.Local(value = LoadRentsBatch.class)
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class LoadRentsBatchEJB implements LoadRentsBatch {
	LoadRentsBatch loadRentsDelegate;
	@EJB
	CreateRentBatch createRentDelegate;
	
	@javax.annotation.PostConstruct
	public void init() {
		
		this.loadRentsDelegate = new LoadRentsBatchImpl(createRentDelegate);

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void loadRentsBatch(List<Rent> rents) throws RentsBatchException {
		this.loadRentsDelegate.loadRentsBatch(rents);
		
	}
	
	// wrong impl: cannot achieve "load all you can" strategy
//	@javax.annotation.PostConstruct
//	public void init() {
//		CreateRentImpl c = new CreateRentImpl();
//		c.setEm(em);
//		this.delegate = new LoadRentsBatchImpl(c);
//
//	}
}
