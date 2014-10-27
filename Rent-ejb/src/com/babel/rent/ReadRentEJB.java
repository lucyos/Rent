package com.babel.rent;

import com.babel.rent.Rent;
import com.babel.rent.ReadRent;
import com.babel.rent.ReadRentImpl;

@javax.ejb.Stateless(name = "ReadRentEJB",mappedName = "ReadRentEJB") 
@javax.ejb.Remote(value=ReadRent.class) 
@javax.ejb.Local(value=ReadRent.class) 
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class ReadRentEJB implements ReadRent {

	private ReadRent delegate;
	@javax.persistence.PersistenceContext(unitName="myJPAUnit")
	private javax.persistence.EntityManager em;

	public ReadRentEJB(){

	}

	public void finalize() throws Throwable {

	}
	@javax.annotation.PostConstruct
	public void init(){
		this.delegate=new ReadRentImpl(); 
		 (( ReadRentImpl)this.delegate).setEm(em);
	}

	/**
	 * 
	 * @param p
	 */
	public Rent readRent(Long p){
		return this.delegate.readRent(p);
	}
}//end ReadRentEJB