package com.esprit.microservices.services;

import java.util.Date;
import java.util.List;

import com.esprit.microservices.entities.Event;



public interface IServiceEvent {

	public Event addEvent(Event event);
	public Event updateEvent(int id , Event event);
	public String deleteEvent(int id);
	public List<Event> getEvents ();
	public Event getEvent(int id);
	public List<Event> getEventByTitle(String name);
	public List<Event> getEventByDate(Date date);
	
}
