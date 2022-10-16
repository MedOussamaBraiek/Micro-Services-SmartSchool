package com.esprit.microservice.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.microservice.entities.Reclamation;
import com.esprit.microservice.repositories.ReclamationRepositrory;


@Service
public  class ReclamationService implements IReclamationService {
    @Autowired
    ReclamationRepositrory reclamationRepositrory;
	@Override
	public Reclamation addReclamation(Reclamation reclamation) {
		// TODO Auto-generated method stub
		Date newDate = new Date();
		reclamation.setDate(newDate);
		return reclamationRepositrory.save(reclamation);
	}

	
		

	@Override
	public String deleteReclamation(int id) {
		// TODO Auto-generated method stub
		reclamationRepositrory.deleteById(id);
		return "Relamation deleted successfuly";
	}

	@Override
	public List<Reclamation> getReclamations() {
		
		return reclamationRepositrory.findAll();
	}

	@Override
	public Reclamation getReclamationById(int id) {
		
		return reclamationRepositrory.findById(id).get();
	}

	@Override
	public List<Reclamation> getReclamationsByTitle(String title) {
		// TODO Auto-generated method stub
		List<Reclamation>reclamations=reclamationRepositrory.findReclamationsByTitle(title);
		return reclamations;
	}

	@Override
	public List<Reclamation> getReclamationsByOwner(String name) {
		List<Reclamation>reclamations=reclamationRepositrory.findReclamationsByOwner(name);
		return reclamations;
	}

	@Override
	public List<Reclamation> getReclamationsByDate(Date date) {
		List<Reclamation>reclamations=reclamationRepositrory.findReclamationsByDate(date);
		return reclamations;
	}

	@Override
	public Reclamation updateReclamationByOwner(int id, Reclamation newreclamation) {
		// TODO Auto-generated method stub
		Reclamation r = reclamationRepositrory.findById(id).get();
		r.setTitle(newreclamation.getTitle());
		r.setContent(newreclamation.getContent());
		r.setDate(newreclamation.getDate());
		r.setStatus(newreclamation.getStatus());
		return reclamationRepositrory.save(r);
	
			}

	

	
}
