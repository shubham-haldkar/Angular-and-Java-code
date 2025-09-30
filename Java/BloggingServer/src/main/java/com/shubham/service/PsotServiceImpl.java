package com.shubham.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.entity.Post;
import com.shubham.repository.PostRepository;

@Service
public class PsotServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo ;
	
	public Post savePost(Post post) {
		post.setLikeCount(0) ;
		post.setViewCount(0) ;
		post.setDate(new Date()) ;
		
		return postRepo.save(post);
	}
}
