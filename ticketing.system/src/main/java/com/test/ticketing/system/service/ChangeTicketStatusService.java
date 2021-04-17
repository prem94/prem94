package com.test.ticketing.system.service;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class ChangeTicketStatusService {
	
	@Autowired
	private TicketService ticketService; 
	
	@Scheduled(cron ="0 0 0 * * *")
	public void StatusChanger() {
		
		LocalDate currentDate = LocalDate.now();
		LocalDate currentDateMinus30Days = currentDate.minusDays(30);
		
		System.out.println("currentDate: " + currentDate);
		System.out.println("currentDateMinus30Days : " + currentDateMinus30Days);
		
		ticketService.getAllTickets().forEach(ticket ->{
			System.out.println("Ticket : "+ticket.getDate());
			LocalDate ticketUpdatedDate = ticket.getDate();
			System.out.println("ticketUpdatedDate : "+ ticketUpdatedDate);
			if (ticket.getStatus().equals("resolved") && ticketUpdatedDate.isBefore(currentDateMinus30Days)) {
				ticket.setStatus("closed");
				ticketService.updateTicket(ticket);
		      }
		});	
	}

}
