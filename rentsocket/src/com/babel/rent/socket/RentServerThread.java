package com.babel.rent.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class RentServerThread extends Thread {

	private Socket socket = null;
	private CreateCSVRent worker = null;

	public RentServerThread(Socket socket) {
		super("RentServerThread");
		//keep the socket initiated by the client call
		this.socket = socket;
		//inject the worker that will actually execute the business logic
		this.worker = RentSocketFactory.createCSVRentFactory();
	}

	public void run() {
		PrintWriter out=null;
		BufferedReader in =null;
		try {

			 out = new PrintWriter(socket.getOutputStream(), true);
			//socket.getInputStream().
			 in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String inputLine, outputLine;
			//expecting a multi-line text according to CreateCSVRent protocol
			//read the string message line by line and reconstruct the client's message
			StringBuffer buf=new StringBuffer();
			
			while ((inputLine = in.readLine()) != null && inputLine.length()>0) {

				buf.append(inputLine).append("\n");			
					
			}
			System.out.println("client message"+ buf.toString());
			//delegate the business logic to the associated worker
			String rentExternalId=this.worker.createCSVRent(buf.toString());
			System.out.println("new rent created:"+rentExternalId);
			//respond with the new rent id
			out.println(rentExternalId);

		} catch (Throwable e) {
			e.printStackTrace();
			out.print(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
