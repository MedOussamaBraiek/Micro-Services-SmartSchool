package com.microservice.forum.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.forum.entities.Forum;
import com.microservice.forum.entities.ForumType;
import com.microservice.forum.entities.Post;
import com.microservice.forum.services.IForumService;

@RestController
@RequestMapping("forums")
@CrossOrigin(origins = "http://localhost:3000")
public class ForumRestController {

	@Autowired
	IForumService iForumService;

	@PostMapping("/add")
	public ResponseEntity<Forum> addPost(@RequestBody Forum forum) {

		return new ResponseEntity<Forum>(iForumService.addForum(forum), HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Forum> update(@RequestBody Forum forum) {

		return new ResponseEntity<Forum>(iForumService.updateForum(forum), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {

		iForumService.deleteForum(id);

		return new ResponseEntity<String>("Forum deleted", HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Forum> findById(@PathVariable("id") int id) {

		return new ResponseEntity<Forum>(iForumService.getForumById(id), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<Forum>> getAllPosts() {

		return new ResponseEntity<List<Forum>>(iForumService.getAllForums(), HttpStatus.OK);

	}

	@GetMapping("/forum/{id}")
	public ResponseEntity<List<Post>> getPostsByForum(@PathVariable("id") int id) {

		return new ResponseEntity<List<Post>>(iForumService.getPostByForum(id), HttpStatus.OK);

	}

	@PutMapping("/forum/{id}")
	public ResponseEntity<Forum> assignPostsToForums(@PathVariable("id") int id, List<Post> posList) {

		return new ResponseEntity<Forum>(iForumService.assignPostsToForums(posList, id), HttpStatus.OK);
	}

	@PutMapping("/date")
	public ResponseEntity<List<Forum>> getForumByDate(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

		return new ResponseEntity<List<Forum>>(iForumService.findForumsByDate(date), HttpStatus.OK);

	}

	@PutMapping("/type")
	public ResponseEntity<List<Forum>> getForumByDate(@RequestParam("type") ForumType type) {

		return new ResponseEntity<List<Forum>>(iForumService.findForumsByType(type), HttpStatus.OK);

	}

}
