package com.aits.TransportManagement;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusService implements Service{
	
	Map<String,TransportService > travel;
	@Autowired
	public BusService(Map<String,TransportService> travel)
	{
		this.travel=travel;
	}
	
	String source;
	String destination;
	@Override
	public void setSource(String source) {
		// TODO Auto-generated method stub
		this.source=source;
	}

	@Override
	public void setDestination(String destination) {
		// TODO Auto-generated method stub
		this.destination=destination;
	}

	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return source;
	}

	@Override
	public String getdestination() {
		// TODO Auto-generated method stub
		return destination;
	}
	public void showTicket(String travelMode)
	{
		TransportService s=travel.get(travelMode);
		s.bookTicket(source,destination);
	}

	@Override
	public void showTicket() {
		// TODO Auto-generated method stub
		
	}

}
