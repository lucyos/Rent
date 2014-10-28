package com.babel.rent.ws;

public class RentImplOverLocalEJBFactory extends RentImplOverRemoteEJBFactory{

	protected RentImplOverLocalEJBFactory(){
		super("local");
	}
}
