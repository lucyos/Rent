package com.babel.rentioemail;

public class EmailMessage {

	private String from;
	private String message;
	private String subject;
	private String to;

	public EmailMessage(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public String getFrom(){
		return this.from;
	}

	public String getMessage(){
		return this.message;
	}

	public String getSubject(){
		return this.subject;
	}

	public String getTo(){
		return this.to;
	}

	/**
	 * 
	 * @param from
	 */
	public void setFrom(String from){
		this.from=from;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message){
		this.message=message;
	}

	/**
	 * 
	 * @param subject
	 */
	public void setSubject(String subject){
		this.subject=subject;
	}

	/**
	 * 
	 * @param to
	 */
	public void setTo(String to){
		this.to=to;
	}
}//end EmailMessage