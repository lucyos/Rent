package com.babel.rent.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;


public class CreateCSVRentClientServerTest {

	@Test
	public void test1() throws UnknownHostException, IOException {
		Socket clientSocket = null;
		try {
			clientSocket = new Socket("localhost", 4444);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
					true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			//Send the text message with the new Rent 
			//Remember the text format has to implement the app-specific protocol
			out.println(CreateCSVRentTest.buildNewRentCSVText());
			out.print((char)13);//signal the end of the message
			
			System.out.println("server response (the new rent's external ID): " + in.readLine());
			clientSocket.close();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			clientSocket.close();
		}


	}
}
