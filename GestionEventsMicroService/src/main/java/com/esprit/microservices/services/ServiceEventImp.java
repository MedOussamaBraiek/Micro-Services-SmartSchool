package com.esprit.microservices.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservices.entities.Event;
import com.esprit.microservices.repositories.EventRepo;

@Service
public class ServiceEventImp implements IServiceEvent {

	@Autowired
	EventRepo repo;

	@Override
	public List<Event> getEvents() {

		return repo.findAll();
	}

	@Override
	public Event getEvent(int id) {

		return repo.findById(id).get();
	}

	@Override
	public Event addEvent(Event event) {
		return repo.save(event);
	}

	@Override
	public Event updateEvent(int id, Event newEvent) {
		Event e = repo.findById(id).get();
		e.setTitle(newEvent.getTitle());
		e.setDescription(newEvent.getDescription());
		e.setEventDate(newEvent.getEventDate());
		e.setType(newEvent.getType());

		return repo.save(e);
	}

	@Override
	public String deleteEvent(int id) {
		repo.deleteById(id);
		return "Event deleted successfully !" ;
	}

	@Override
	public List<Event> getEventByTitle(String name) {
		List<Event> events= repo.findEventByTitle(name);
		return events;
	}

	@Override
	public List<Event> getEventByDate(Date date) {
		List<Event> events= repo.findEventByDate(date);
		return events;
	}

}
