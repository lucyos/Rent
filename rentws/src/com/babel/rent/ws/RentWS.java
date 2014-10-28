package com.babel.rent.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.Persistence;

import com.babel.rent.CreateRent;
import com.babel.rent.CreateRentImpl;
import com.babel.rent.Rent;
import com.babel.rent.ReadRent;
import com.babel.rent.ReadRentImpl;
import com.babel.rent.SaveRent;
import com.babel.rent.SaveRentImpl;


@WebService
@SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.RPC)//ok, this will be deprecated, eventually
public class RentWS implements CreateRent, ReadRent, SaveRent {

	private CreateRent createRentDelegate;
	private ReadRent readRentDelegate;
	private SaveRent saveRentDelegate;
	
	

	public RentWS(){
		//IMPORTANT: Be aware of the transaction management here!
		//@see the getInstance comment!
		this.createRentDelegate=RentImplFactory.getInstance().createRentFactory();
		this.readRentDelegate=RentImplFactory.getInstance().readRentFactory();
		this.saveRentDelegate=RentImplFactory.getInstance().saveRentFactory();
		
		
		
	}

	
	@Override
	@WebMethod
	public Rent createRent(Rent p){
	    
		return this.createRentDelegate.createRent(p);
	}
	@Override
	@WebMethod
	public Rent saveRent(Rent p) {
		return this.saveRentDelegate.saveRent(p);
	}

	@Override
	@WebMethod
	public Rent readRent(Long p) {
		return this.readRentDelegate.readRent(p);//new Rent();
	}
}