package com.test.ticketing.system.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TicketAssignmentService {
	
	@Autowired
	private TicketService ticketService; 

	@Scheduled(cron ="*/5 * * * * *")
	public void ticketAssignment() {
	
	    int j=0;
		long ticketsCount=ticketService.getAllTickets().stream().filter(ticket-> "open".equals(ticket.getStatus())).count();
		long agentsCount=ticketService.getAllTickets().stream().filter(ticket -> !ticket.getAssignedToAgent().isEmpty()).map(ticket -> ticket.getAssignedToAgent()).distinct().count();
		List<String> agents=ticketService.getAllTickets().stream().filter(ticket -> !ticket.getAssignedToAgent().isEmpty()).map(ticket -> ticket.getAssignedToAgent()).distinct().collect(Collectors.toList());
		List<Long> ticketIds=ticketService.getAllTickets().stream().filter(ticket-> "open".equals(ticket.getStatus())).map(ticket -> ticket.getId()).collect(Collectors.toList());

		try {
		int AssignedcountForEach=(int) (ticketsCount/agentsCount);	
		
			for(String agent: agents) {
				int i=0;
				while(i<AssignedcountForEach) {
				ticketService.assignTicketToAgent(ticketIds.get(j), agent);
				i++;
				j++;
				}		
			}
			for(int i = j; i <ticketIds.size(); i++)
			{
				ticketService.assignTicketToAgent(ticketIds.get(i), "");
			}

		}catch(ArithmeticException e) {
			System.out.println("No Tickets Present in System");
		}
 			}

}
