package com.aits.TransportManagement;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication
public class TransMgmtAppContext {
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TransMgmtAppContext.class);
		BusService b=(BusService) context.getBean(BusService.class);
		Scanner s=new Scanner(System.in);
		System.out.print("Enter travel mode: ");
		String travelMode=s.next();
		System.out.print("Enter source: ");
		String source=s.next();
		b.setSource(source);
		System.out.print("Enter destination: ");
		String destination=s.next();
		b.setDestination(destination);
		b.showTicket(travelMode);
		//System.out.println(b.getSource());
	}

}
