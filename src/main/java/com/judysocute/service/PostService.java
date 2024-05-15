package com.judysocute.service;

import java.util.Optional;

import com.judysocute.model.Post;

public interface PostService {

	Iterable<Post> findAllPosts();
	
	Optional<Post> findBySlug(String slug);
	
	void save(Post post);
	
}
