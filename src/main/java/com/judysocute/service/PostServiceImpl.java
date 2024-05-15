package com.judysocute.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.judysocute.model.Post;
import com.judysocute.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void save(Post post) {
		postRepository.save(post);
	}

	@Override
	public Iterable<Post> findAllPosts() {
		return null;
	}

	@Override
	public Optional<Post> findBySlug(String slug) {
		return postRepository.findById(slug);
	}
	
	
	
}
