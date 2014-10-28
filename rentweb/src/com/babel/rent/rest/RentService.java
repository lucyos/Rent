package com.babel.rent.rest;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.babel.rent.CreateRent;
import com.babel.rent.Rent;
import com.babel.rent.RentLine;
import com.babel.rent.ReadRent;
import com.babel.rent.SaveRent;


@Path("/rents")
public class RentService {

	CreateRent createRentDelegate;
	ReadRent readRentDelegate;
	SaveRent saveRentDelegate;
	
	public RentService() {
		this.createRentDelegate=RentImplFactory.getInstance().createRentFactory();
		this.readRentDelegate=RentImplFactory.getInstance().readRentFactory();
		this.saveRentDelegate=RentImplFactory.getInstance().saveRentFactory();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Rent createRent(Rent p) {
		return this.createRentDelegate.createRent(p);
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Rent readRent(@PathParam("id") Long id) {
//		Rent p= new Rent();
//		p.getRentLines().add(new RentLine());
//		p.getRentLines().add(new RentLine());
//		return p;
		
		Rent e = this.readRentDelegate.readRent(id);
		e.purify();
		return e;
	}

	
	@PUT
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Rent saveRent(Rent p) {
		return this.saveRentDelegate.saveRent(p);
	}
	
	@GET
	@Path("/template")
	@Produces({ MediaType.APPLICATION_JSON })
	public Rent newRent() {
		return new Rent();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Rent> readAllRents() {
		return new LinkedList<Rent>();
		//TODO: implement the ReadRentsAll interface
	}
}// end RentService