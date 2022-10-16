package com.esprit.microservice.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entities.Reclamation;
import com.esprit.microservice.services.IReclamationService;



@RestController
@RequestMapping("/reclamations")
public class ReclamationController {

	@Autowired
	IReclamationService reclamationService ;
	
	@PostMapping("/add")
	public ResponseEntity<Reclamation> addReclamation (@RequestBody Reclamation reclamation){
		reclamation.setStatus(false);
		return new ResponseEntity<Reclamation>(reclamationService.addReclamation(reclamation),HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Reclamation> updateReclamation (@PathVariable("id") int id,@RequestBody Reclamation reclamation){
		Date newdateDate= new Date();
		reclamation.setDate(newdateDate);
		return new ResponseEntity<Reclamation>(reclamationService.updateReclamationByOwner(id, reclamation),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteReclamation (@PathVariable("id") int id){
		return new ResponseEntity<String>(reclamationService.deleteReclamation(id),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Reclamation>>getReclamations(){
		return new ResponseEntity<List<Reclamation>>(reclamationService.getReclamations(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Reclamation>getReclamation(@PathVariable("id")int id){
		return new ResponseEntity<Reclamation>(reclamationService.getReclamationById(id),HttpStatus.OK);
	}
	@GetMapping("/title")
	public ResponseEntity<List<Reclamation>>getReclamationsByTitle(@RequestParam("title")String title){
		return new ResponseEntity<List<Reclamation>>(reclamationService.getReclamationsByTitle(title),HttpStatus.OK);
	}
	@GetMapping("/name")
	public ResponseEntity<List<Reclamation>>getReclamationsByOwner(@RequestParam("name")String name){
		return new ResponseEntity<List<Reclamation>>(reclamationService.getReclamationsByOwner(name),HttpStatus.OK);
	}
	@GetMapping("/date")
	public ResponseEntity<List<Reclamation>>getReclamationsByDate(@RequestParam("date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
		return new ResponseEntity<List<Reclamation>>(reclamationService.getReclamationsByDate(date),HttpStatus.OK);
	}
}
