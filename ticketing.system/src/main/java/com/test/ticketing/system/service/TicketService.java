package com.test.ticketing.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ticketing.system.entities.Ticket;
import com.test.ticketing.system.repository.TicketRepository;

@Service
public class TicketService {

@Autowired
private TicketRepository ticketRepository;	
	

public List<Ticket> getAllTickets() {
	return (List<Ticket>) ticketRepository.findAll();
}

public Ticket getTicket(Long id) {
	
	return ticketRepository.findById(id).isPresent()? ticketRepository.findById(id).get() : null;
}

public boolean addTicket(Ticket ticket) {
	return ticketRepository.save(ticket) != null;
}

public void deleteTicket(Ticket ticket) {
	
 ticketRepository.delete(ticket);	
}

public boolean updateTicket(Ticket ticket) {
	
	return ticketRepository.save(ticket) != null;
}

public List<Ticket> getTicketsByAgent(String agent) {
	
	return ticketRepository.findByAssignedToAgent(agent);
}

public List<Ticket> getTicketsByCustomer(String customer) {
	
	return ticketRepository.findByCustomer(customer);
}

public List<Ticket> getTicketsByStatus(String status) {
	
	return ticketRepository.findByStatus(status);
}

public boolean updateTicketStatus(Long id, String status) {
	
  if(ticketRepository.findById(id).isPresent()) {
	 Ticket ticket = ticketRepository.findById(id).get();
	 ticket.setStatus(status);
	  ticketRepository.save(ticket);
	  return true;
  }
  
  return false;

}

public boolean assignTicketToAgent(Long id, String agent) {
	 if(ticketRepository.findById(id).isPresent()) {
		 Ticket ticket = ticketRepository.findById(id).get();
		 ticket.setAssignedToAgent(agent);
		  ticketRepository.save(ticket);
		  return true;
	  }
	  
	  return false;
}

}
