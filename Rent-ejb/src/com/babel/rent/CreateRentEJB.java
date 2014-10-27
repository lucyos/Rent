package com.babel.rent;

import com.babel.rent.CreateRent;
import com.babel.rent.CreateRentImpl;
import com.babel.rent.Rent;

@javax.ejb.Stateless 
@javax.ejb.Remote(value=CreateRent.class) 
@javax.ejb.Local(value=CreateRent.class) //JBoss 4.2 still supports same interface as Remote. Otherwise, extend remote interfce with anither interface
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class CreateRentEJB implements CreateRent {

	private CreateRent delegate;
	@javax.persistence.PersistenceContext(unitName="myJPAUnit")
	private javax.persistence.EntityManager em;

	public CreateRentEJB(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param p
	 */
	public Rent createRent(Rent p){
		return this.delegate.createRent(p);
	}

	@javax.annotation.PostConstruct
	public void init(){
		this.delegate=new CreateRentImpl(); 
		 (( CreateRentImpl)this.delegate).setEm(em);
	}
}//end CreateRentEJB