package com.babel.rent.rest;

public class RentImplOverLocalEJBFactory extends RentImplOverRemoteEJBFactory{

	protected RentImplOverLocalEJBFactory(){
		super("local");
	}
}
