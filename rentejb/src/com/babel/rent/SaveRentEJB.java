package com.babel.rent;

import javax.interceptor.Interceptors;

@javax.ejb.Stateless(name = "SaveRentEJB",mappedName = "SaveRentEJB") 
@javax.ejb.Remote(value=SaveRent.class) 
//@javax.ejb.Local(value=SaveRent.class) 
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class SaveRentEJB implements SaveRent {

	private SaveRent delegate;
	@javax.persistence.PersistenceContext(unitName="myJPAUnit")
	private javax.persistence.EntityManager em;

	public SaveRentEJB(){

	}
//
	public void finalize() throws Throwable {

	}
	@javax.annotation.PostConstruct
	public void init(){
		this.delegate=new SaveRentImpl(); 
		 (( SaveRentImpl)this.delegate).setEm(em);
	}

	/**
	 * 
	 * @param p
	 */
//	@Interceptors(value={com.babel.interceptor.NullParamValidator.class})
	public Rent saveRent(Rent p){
		return this.delegate.saveRent(p);
	}
}//end SaveRentEJB