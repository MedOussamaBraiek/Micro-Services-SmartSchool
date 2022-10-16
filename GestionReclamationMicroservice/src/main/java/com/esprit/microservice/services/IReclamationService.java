package com.esprit.microservice.services;

import java.util.Date;
import java.util.List;

import com.esprit.microservice.entities.Reclamation;



public interface IReclamationService {
	public Reclamation addReclamation(Reclamation reclamation);
	public Reclamation updateReclamationByOwner(int id , Reclamation reclamation);
	public String deleteReclamation(int id);
	public List<Reclamation> getReclamations ();
	public Reclamation getReclamationById(int id);
	public List<Reclamation> getReclamationsByTitle(String title);
	public List<Reclamation> getReclamationsByOwner(String name);
	public List<Reclamation> getReclamationsByDate(Date date);
	
}
