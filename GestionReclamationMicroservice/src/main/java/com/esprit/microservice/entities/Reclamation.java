package com.esprit.microservice.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reclamation implements Serializable {
	private static final long serialVersionUID = -7291192279156300175L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String title ;
	private String content ;
	private Boolean status;
	private String owner;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date date ;
	

}
