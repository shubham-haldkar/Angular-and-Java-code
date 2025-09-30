package com.shubham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.shubham.entity.Post;
import com.shubham.service.PostService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/posts")
public class PostController {
	@Autowired
	private PostService postService ;
	
	@PostMapping("/")
	public ResponseEntity<?> createPost(@RequestBody Post post){
		try {
			Post createPost = postService.savePost(post) ;
			return ResponseEntity.status(HttpStatus.CREATED).body(createPost) ;
		} catch (Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() ;
		}
	}
	
	@GetMapping("/get")
	public String getMethodName() {
		System.out.println("sssss");
		return "success";
	}
	
}
