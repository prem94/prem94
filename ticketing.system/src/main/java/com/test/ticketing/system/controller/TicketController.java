package com.test.ticketing.system.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sendgrid.helpers.mail.Mail;
import com.test.ticketing.system.EmailConfig;
import com.test.ticketing.system.entities.Ticket;
import com.test.ticketing.system.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/ticketById/{id}", method = RequestMethod.GET)
	public Ticket getTicketByID(@PathVariable Long id) {
		return ticketService.getTicket(id);
	}

	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public List<Ticket> getAllTickets() {
		return ticketService.getAllTickets();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public HttpStatus deleteTicket(@RequestBody Ticket ticket) {
		ticketService.deleteTicket(ticket);
		return HttpStatus.OK;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public HttpStatus insertTicket(@RequestBody Ticket ticket) {
		return ticketService.addTicket(ticket) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public HttpStatus updateTicket(@RequestBody Ticket ticket) {
		return ticketService.updateTicket(ticket) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@RequestMapping(value = "/updateticketstatus", method = RequestMethod.PUT)
	public HttpStatus updateTicketStatus(@RequestParam Long id, @RequestParam String status) {
		return ticketService.updateTicketStatus(id,status) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@RequestMapping(value = "/assigntickettoagent", method = RequestMethod.PUT)
	public HttpStatus assignTicketToAgent(@RequestParam Long id, @RequestParam String agent) {
		return ticketService.assignTicketToAgent(id,agent) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/ticketsbyagent", method = RequestMethod.GET)
	public List<Ticket> getTicketsByAgent(String agent) {
		return ticketService.getTicketsByAgent(agent);
	}

	@RequestMapping(value = "/ticketsbystatus", method = RequestMethod.GET)
	public List<Ticket> getTicketsByStatus(String status) {
		return ticketService.getTicketsByStatus(status);
	}

	@RequestMapping(value = "/ticketsbycustomer", method = RequestMethod.GET)
	public List<Ticket> getTicketsByCustomer(String customer) {
		return ticketService.getTicketsByCustomer(customer);
	}

	@RequestMapping(value = "/response", method = RequestMethod.PUT)
	public void respondToTicket(@RequestBody Ticket ticket) throws IOException {
		ticketService.updateTicket(ticket);
		final Mail mail=EmailConfig.buildHelloEmail();
		EmailConfig.send(mail);
	}
}
