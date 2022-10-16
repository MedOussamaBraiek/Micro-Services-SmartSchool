package com.esprit.microservice.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.microservice.entities.Reclamation;



@Repository
public interface ReclamationRepositrory extends JpaRepository<Reclamation, Integer>  {
	@Query("select r from Reclamation r where r.title = :title")
	public List<Reclamation> findReclamationsByTitle(@Param("title")String title);
	@Query("select r from Reclamation r where r.date = :date")
	public List<Reclamation> findReclamationsByDate(@Param("date")Date date);
	@Query("select r from Reclamation r where r.owner = :name")
	public List<Reclamation> findReclamationsByOwner(@Param("name")String name);

}
