package com.microservice.forum.services;


import java.util.Date;
import java.util.List;

import com.microservice.forum.entities.Forum;
import com.microservice.forum.entities.ForumType;
import com.microservice.forum.entities.Post;

public interface IForumService {

	Forum addForum(Forum f);
	void deleteForum(int id);
	Forum updateForum(Forum f);
	Forum getForumById(int id);
	List<Forum>getAllForums();
	List<Post> getPostByForum(int id);
	
	Forum assignPostsToForums(List<Post> posts,int id);

	List <Forum>findForumsByDate(Date date);
	
	List <Forum>findForumsByType(ForumType f);
}
