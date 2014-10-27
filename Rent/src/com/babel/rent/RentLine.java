package com.babel.rent;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.babel.core.data.PersistentEntity;


@Entity
public class RentLine extends PersistentEntity {

	private String carModel;
	 @ManyToOne 
	 @JsonBackReference//("RentLines")
	private Rent rent;
	private double price;
	private double quantity;

	public RentLine(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public String getCarModel(){
		return this.carModel;
	}

	public Rent getRent(){
		return this.rent;
	}

	public double getPrice(){
		return this.price;
	}

	public double getQuantity(){
		return this.quantity;
	}

	/**
	 * 
	 * @param carModel
	 */
	public void setCarModel(String carModel){
		this.carModel=carModel;
	}

	/**
	 * 
	 * @param p
	 */
	public void setRent(Rent p){
		 this.rent=p;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price){
		this.price=price;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(double quantity){
		this.quantity=quantity;
	}
}//end RentLine