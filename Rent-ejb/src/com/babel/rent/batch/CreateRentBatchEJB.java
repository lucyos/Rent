package com.babel.rent.batch;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.babel.rent.CreateRent;
import com.babel.rent.Rent;

@Stateless
@Local (CreateRentBatch.class)//for the moment, only local calls are needed
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class CreateRentBatchEJB implements CreateRentBatch{
	@EJB //inject the original service 
	private CreateRent delegate;
	
//	@javax.persistence.PersistenceContext(unitName="myJPAUnit")
//	private javax.persistence.EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Rent createRent(Rent p){
		return this.delegate.createRent(p);
	}
//
//	@javax.annotation.PostConstruct
//	public void init(){
//		this.delegate=new CreateRentImpl(); 
//		 (( CreateRentImpl)this.delegate).setEm(em);
//	}
}