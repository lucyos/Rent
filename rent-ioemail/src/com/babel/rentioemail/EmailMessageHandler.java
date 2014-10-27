package com.babel.rentioemail;

import javax.mail.Message;
import javax.mail.Session;


public abstract class EmailMessageHandler {

	public EmailMessageHandler(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param emailMessage
	 */
	public abstract void notify(Message emailMessage,  String user, String pass );
}//end EmailMessageHandler