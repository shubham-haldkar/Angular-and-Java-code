package com.shubham.service;

import org.springframework.stereotype.Service;

import com.shubham.entity.Post;

 
public interface PostService {

	Post savePost(Post post);
}
