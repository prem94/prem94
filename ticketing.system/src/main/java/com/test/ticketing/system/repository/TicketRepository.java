package com.test.ticketing.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.test.ticketing.system.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	 
	Optional<Ticket> findById(Long id);
	
	List<Ticket> findByAssignedToAgent(String agent);
	
	List<Ticket> findByCustomer(String customer);
	
	List<Ticket> findByStatus(String status);
}
