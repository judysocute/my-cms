package com.judysocute.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.judysocute.model.Post;

public interface PostRepository extends CrudRepository<Post, String> {
	
	List<Post> findBySlug(String slug);
	
//	Post findByTag(String tag);
}
