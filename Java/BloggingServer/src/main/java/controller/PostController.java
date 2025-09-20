package controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.entity.Post;

import service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService ;
	
	@PostMapping 
	public ResponseEntity<?> createPost(@RequestBody Post post){
		try {
			Post createPost = postService.savePost(post) ;
			return ResponseEntity.status(HttpStatus.CREATED).body(createPost) ;
		} catch (Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() ;
		}
	}
}
