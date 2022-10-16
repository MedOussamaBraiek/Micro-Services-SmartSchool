package com.microservice.forum.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.forum.entities.Forum;
import com.microservice.forum.entities.ForumType;
import com.microservice.forum.entities.Post;
import com.microservice.forum.repositories.ForumRepository;

@Service
public class ForumServiceImpl implements IForumService {

	@Autowired
	ForumRepository forumRepository;

	@Override
	public Forum addForum(Forum f) {
		// TODO Auto-generated method stub
		return forumRepository.save(f);
	}

	@Override
	public void deleteForum(int id) {
		// TODO Auto-generated method stub
		forumRepository.deleteById(id);
	}

	@Override
	public Forum updateForum(Forum f) {
		// TODO Auto-generated method stub
		return forumRepository.save(f);
	}

	@Override
	public Forum getForumById(int id) {
		// TODO Auto-generated method stub
		return forumRepository.findById(id).orElse(null);
	}

	@Override
	public List<Forum> getAllForums() {
		// TODO Auto-generated method stub
		return forumRepository.findAll();
	}

	@Override
	public List<Post> getPostByForum(int id) {
		// TODO Auto-generated method stub

		return this.getForumById(id).getPosts();
	}

	@Override
	public Forum assignPostsToForums(List<Post> posts, int id) {
		// TODO Auto-generated method stub
		this.getForumById(id).getPosts().addAll(posts);
		return this.getForumById(id);
	}

	@Override
	public List<Forum> findForumsByDate(Date date) {
		// TODO Auto-generated method stub
		return forumRepository.findForumByDate(date);
	}

	@Override
	public List<Forum> findForumsByType(ForumType f) {
		// TODO Auto-generated method stub
		List <Forum> forums = new ArrayList<>();
		this.getAllForums().forEach(forum -> {
			if (forum.getType().equals(f)) {
				forums.add(forum);
			}
		});
		return forums;
	}

}
