package com.test.ticketing.system.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id; 

@Column(name = "ticket_type")
private String ticketType;

@Column(name = "description")
private String description;

@Column(name = "title")
private String title;

@Column(name = "created_by_user")
private String createdByUser;

@Column(name = "customer")
private String customer;

@Column(name = "assigned_to_agent")
private String assignedToAgent;

@Column(name = "priority")
private String priority;

@Column(name = "status")
private String status;

@Column(name = "updated_date")
private LocalDate date = LocalDate.now(); 

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getCreatedByUser() {
	return createdByUser;
}

public void setCreatedByUser(String createdByUser) {
	this.createdByUser = createdByUser;
}

public String getCustomer() {
	return customer;
}

public void setCustomer(String customer) {
	this.customer = customer;
}



public String getAssignedToAgent() {
	return assignedToAgent;
}

public void setAssignedToAgent(String assignedToAgent) {
	this.assignedToAgent = assignedToAgent;
}

public String getPriority() {
	return priority;
}

public void setPriority(String priority) {
	this.priority = priority;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getTicketType() {
	return ticketType;
}

public void setTicketType(String ticketType) {
	this.ticketType = ticketType;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((assignedToAgent == null) ? 0 : assignedToAgent.hashCode());
	result = prime * result + ((createdByUser == null) ? 0 : createdByUser.hashCode());
	result = prime * result + ((customer == null) ? 0 : customer.hashCode());
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((priority == null) ? 0 : priority.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((ticketType == null) ? 0 : ticketType.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Ticket other = (Ticket) obj;
	if (assignedToAgent == null) {
		if (other.assignedToAgent != null)
			return false;
	} else if (!assignedToAgent.equals(other.assignedToAgent))
		return false;
	if (createdByUser == null) {
		if (other.createdByUser != null)
			return false;
	} else if (!createdByUser.equals(other.createdByUser))
		return false;
	if (customer == null) {
		if (other.customer != null)
			return false;
	} else if (!customer.equals(other.customer))
		return false;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (priority == null) {
		if (other.priority != null)
			return false;
	} else if (!priority.equals(other.priority))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (ticketType == null) {
		if (other.ticketType != null)
			return false;
	} else if (!ticketType.equals(other.ticketType))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}

@Override
public String toString() {
	return "Ticket [id=" + id + ", ticketType=" + ticketType + ", description=" + description + ", title=" + title
			+ ", createdByUser=" + createdByUser + ", customer=" + customer + ", assignedToAgent=" + assignedToAgent
			+ ", priority=" + priority + ", status=" + status + ", date=" + date + "]";
}


}
