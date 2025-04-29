package com.aits.TransportManagement;

import org.springframework.stereotype.Component;

@Component("flight")
public class Flight implements TransportService {
	public void bookTicket(String source,String destination)
	{
		System.out.println("Ticket booked from "+source+" to "+destination+" through flight");
	}
}
