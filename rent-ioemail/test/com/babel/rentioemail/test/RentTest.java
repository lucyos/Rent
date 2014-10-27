package com.babel.rentioemail.test;

import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.babel.rentioemail.EmailMessageHandler;
import com.babel.rentioemail.ReadEmails;
import com.babel.rentioemail.ReadEmailsImpl;
import com.babel.rentioemail.handlers.CreateRentHandler;


public class RentTest {

	ReadEmails readEmailsWorker;

	@Before
	public void init() throws NamingException {
		List<EmailMessageHandler> handlers=new LinkedList<EmailMessageHandler>();
		handlers.add(new CreateRentHandler());
		readEmailsWorker=new ReadEmailsImpl(handlers);
	}
	
	@Test
	public void testCreateRentFromEmail(){
		readEmailsWorker.readEmails();
	}

}
