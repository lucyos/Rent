package com.babel.rent.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.babel.rent.Rent;
import com.babel.rent.RentLine;

@Path("/test")
public class TestService {
//	@GET
//	@Produces({ MediaType.APPLICATION_JSON })
	public Prod newProd() {
		Prod p= new Prod();
		p.getLines().add(new Linie());
		return p;
	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Rent newRent() {
		Rent p= new Rent();
		p.getRentLines().add(new RentLine());
		p.getRentLines().add(new RentLine());
		return p;
	}

}
