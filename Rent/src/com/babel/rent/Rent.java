package com.babel.rent;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.babel.core.data.PersistentEntity;

@Entity 
@Table(name="RentTable")
@XmlRootElement
public class Rent extends PersistentEntity {

	
	private String clientEmail;
	private String clientName;
	private String clientAddress;
	private String bankAccount;
	private Date rentDate;
	private String notes;
	
	private String processId;
	
	@XmlElement
	@XmlElementWrapper(name="rentLines")
	@OneToMany(mappedBy="rent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  @org.hibernate.annotations.Cascade(value=org.hibernate.annotations.CascadeType.DELETE_ORPHAN) 
	@JsonManagedReference 	
	private Set<RentLine> rentLines = new HashSet<RentLine>();

	public Rent() {

	}
	
	
	public Double calculateRentValue(){
		double s=0;
		for (RentLine l:this.rentLines)
			s=s+l.getPrice()*l.getQuantity();
		return s;
	}
	public void finalize() throws Throwable {
		super.finalize();
	}

	

	public String getClientEmail() {
		return this.clientEmail;
	}

	public String getClientName() {
		return this.clientName;
	}

	public String getClientAddress() {
		return this.clientAddress;
	}

	public Date getRentDate() {
		return this.rentDate;
	}

	

	public String getNotes() {
		return this.notes;
	}

	/**
	 * 
	 * @param clientEmail
	 */
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	/**
	 * 
	 * @param clientName
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * 
	 * @param clientAddress
	 */
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	/**
	 * 
	 * @param rentDate
	 */
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	/**
	 * 
	 * @param notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * 
	 * @param p
	 */
	public void addRentLine(RentLine p){
		 this.rentLines.add(p);
		 p.setRent(this);
	}




	public String getProcessId() {
		return processId;
	}



	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public Set<RentLine> getRentLines() {
		return rentLines;
	}


	public void setRentLines(Set<RentLine> rentLines) {
		this.rentLines = rentLines;
	}


	public String getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	
}// end Rent