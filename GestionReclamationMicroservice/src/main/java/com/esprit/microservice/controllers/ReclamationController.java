package com.esprit.microservice.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.esprit.microservice.bean.UserResponse;
import com.esprit.microservice.client.UserClient;
import com.esprit.microservice.entities.Reclamation;
import com.esprit.microservice.services.IReclamationService;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;


@RestController
@RequestMapping("/reclamations")
public class ReclamationController {

	@Autowired
	IReclamationService reclamationService ;
	@Autowired
	UserClient userClient;
	@PostMapping("/add")
	public ResponseEntity<Reclamation> addReclamation (@RequestBody Reclamation reclamation){
	
		return new ResponseEntity<Reclamation>(reclamationService.addReclamation(reclamation),HttpStatus.CREATED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Reclamation> updateReclamationByOwner (@PathVariable("id") int id,@RequestBody Reclamation reclamation){
		Date newdateDate= new Date();
		reclamation.setDate(newdateDate);
		return new ResponseEntity<Reclamation>(reclamationService.updateReclamationByOwner(id, reclamation),HttpStatus.OK);
	}
	@PutMapping("/verifyReclamation/{id}")
	public ResponseEntity<Reclamation> VerifyReclamationByAdmin (@PathVariable("id") int id,@RequestBody Reclamation reclamation){
		
		return new ResponseEntity<Reclamation>(reclamationService.verifyReclamationByAdmin(id, reclamation.getStatus()),HttpStatus.OK);
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
	@GetMapping("/ownerId")
	public ResponseEntity<List<Reclamation>>getReclamationsByOwner(@RequestParam("ownerId")String ownerId){
		return new ResponseEntity<List<Reclamation>>(reclamationService.getReclamationsByOwner(ownerId),HttpStatus.OK);
	}
	
	@GetMapping("/twoDates/{startDate}/{endDate}")
	public ResponseEntity<List<Reclamation>>getReclamationsBetweenTwoDates(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date startDate,@PathVariable("endDate")@DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){
		return new ResponseEntity<List<Reclamation>>(reclamationService.getReclamationsBetweenTwoDate(startDate,endDate),HttpStatus.OK);
	}
	@GetMapping("/filter")
	public ResponseEntity<List<Reclamation>>getFiltredReclamations(
			@RequestParam(name = "title",required = false)String title,
			@RequestParam(name="status",required = false)boolean status,
			@RequestParam(name="ownerId",required = false)Integer ownerId,
			//@RequestParam(name="date",required=false)@DateTimeFormat(pattern = "yyyy-MM-dd")Date date
			@RequestParam(name="startDate",required=false)@DateTimeFormat(pattern = "yyyy-MM-dd")Date startDate,
			@RequestParam(name="endDate",required=false)@DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate
			){
		return new ResponseEntity<List<Reclamation>>(reclamationService.getfilterReclamations(title,status,ownerId,startDate,endDate),HttpStatus.OK);
	}
	@GetMapping("/user")
	public UserResponse getUser(HttpServletRequest request) {
        
		return userClient.getUser(request.getHeader(AUTHORIZATION));
        
	}
	
}