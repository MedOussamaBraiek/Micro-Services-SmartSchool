package com.microservice.forum.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Forum implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String Topic;
	@Enumerated(EnumType.STRING)
	private ForumType type;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date created;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date closed;

	private int createdBy;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "forum")
	private List<Post> posts;
}
