package com.aits.TransportManagement;

import org.springframework.stereotype.Component;

@Component("train")
public class Train implements TransportService{
	public void bookTicket(String source,String destination)
	{
		System.out.println("Ticket booked from "+source+" to "+destination+" through train");
	}

}
