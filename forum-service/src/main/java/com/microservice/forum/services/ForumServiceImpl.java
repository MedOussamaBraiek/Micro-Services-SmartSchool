package com.microservice.forum.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.microservice.forum.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.microservice.forum.entities.Forum;
import com.microservice.forum.entities.ForumType;
import com.microservice.forum.entities.Post;
import com.microservice.forum.repositories.ForumRepository;

@Service
public class ForumServiceImpl implements IForumService {
    @Autowired
    UserClient userClient;
    @Autowired
    ForumRepository forumRepository;

    @Autowired
    IPostService iPostService;

    @Override
    public Forum addForum(Forum f) {
        f.setCreatedBy(Integer.parseInt(userClient.getUser().getId()));
        return forumRepository.save(f);
    }

    @Override
    public void deleteForum(int id) {

        forumRepository.deleteById(id);
    }

    @Override
    public Forum updateForum(Forum f) {

        return forumRepository.save(f);
    }

    @Override
    public Forum getForumById(int id) {

        return forumRepository.findById(id).orElse(null);
    }

    @Override
    public List<Forum> getAllForums() {

//		Forum forum = Forum
//				.builder()
//				.id(3)
//				.created(null)
//				.createdBy(null)
//				.title("jasser")
//				.build();
//		System.out.println(forum.toString());
//		Example<Forum> employeeExample = Example.of(forum);
//		return forumRepository.findAll(employeeExample);
        return forumRepository.findAll();
    }

    @Override
    public List<Post> getPostByForum(int id) {


        return this.getForumById(id).getPosts();
    }

    @Override
    public Forum assignPostsToForums(List<Post> posts, int id) {

        for (Post p : posts) {
            iPostService.AddPost(p);
            p.setForum(this.getForumById(id));
            this.getForumById(id).getPosts().add(p);
        }

        return this.getForumById(id);
    }

    @Override
    public List<Forum> findForumsByDate(Date date) {

        return forumRepository.findForumByDate(date);
    }

    @Override
    public List<Forum> findForumsByType(ForumType f) {

        List<Forum> forums = new ArrayList<>();
        this.getAllForums().forEach(forum -> {
            if (forum.getType().equals(f)) {
                forums.add(forum);
            }
        });
        return forums;
    }

}
