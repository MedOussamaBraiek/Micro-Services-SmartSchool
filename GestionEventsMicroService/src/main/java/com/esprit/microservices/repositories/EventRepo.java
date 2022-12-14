package com.esprit.microservices.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.microservices.entities.Event;

@Repository

public interface EventRepo extends JpaRepository<Event, Integer> {

	@Query("select e from Event e where e.title = :title")
	public List<Event> findEventByTitle(@Param("title")String title);

	@Query("select e from Event e where e.eventDate = :date")
	public List<Event> findEventByDate(@Param("date")Date date);

}
