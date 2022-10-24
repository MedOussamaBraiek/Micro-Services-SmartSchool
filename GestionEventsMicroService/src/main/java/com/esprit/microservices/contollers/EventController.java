package com.esprit.microservices.contollers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservices.entities.Event;
import com.esprit.microservices.services.IServiceEvent;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

	@Autowired
	IServiceEvent serviceEvent ;
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add")
	public ResponseEntity<Event> addEvent (@RequestBody Event event){
		return new ResponseEntity<Event>(serviceEvent.addEvent(event),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/update/{id}")
	public ResponseEntity<Event> updateEvent (@PathVariable("id") int id,@RequestBody Event event){
		return new ResponseEntity<Event>(serviceEvent.updateEvent(id, event),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEvent (@PathVariable("id") int id){
		return new ResponseEntity<String>(serviceEvent.deleteEvent(id),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public ResponseEntity<List<Event>>getEvents(){
		return new ResponseEntity<List<Event>>(serviceEvent.getEvents(),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/{id}")
	public ResponseEntity<Event>getEvent(@PathVariable("id")int id){
		return new ResponseEntity<Event>(serviceEvent.getEvent(id),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/title")
	public ResponseEntity<List<Event>>getEventsByTitle(@RequestParam("title")String title){
		return new ResponseEntity<List<Event>>(serviceEvent.getEventByTitle(title),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/date")
	public ResponseEntity<List<Event>>getEventsByDate(@RequestParam("date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
		return new ResponseEntity<List<Event>>(serviceEvent.getEventByDate(date),HttpStatus.OK);
	}
}
