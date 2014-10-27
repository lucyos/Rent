package com.babel.rent;

import java.util.LinkedList;
import java.util.List;

public class RentsBatchException extends Exception {
	
	List<Rent> rentsInError=new LinkedList<Rent>();

	public RentsBatchException() {
		super();
	}
	public void addRentInError(Rent o){
		this.rentsInError.add(o);
	}
	@Override
	public String getMessage(){
		return "The folowing rents have errors:"+rentsInError.toArray();
	}

}
