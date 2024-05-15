package com.judysocute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.judysocute.model.Post;
import com.judysocute.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/post")
	public Post createPost(@RequestBody Post post) {
//		postService.save(post);
		System.out.println(post);
		return post;
	}

}
