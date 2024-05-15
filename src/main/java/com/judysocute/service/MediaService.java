package com.judysocute.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.judysocute.model.Media;

public interface MediaService {
	
	void init();
	
	Iterable<Media> findAllMedia();
	
	Optional<Media> findById(Long id);
	
	void save(Media media, MultipartFile file);

}
