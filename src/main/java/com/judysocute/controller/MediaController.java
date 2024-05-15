package com.judysocute.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.judysocute.model.Media;
import com.judysocute.service.MediaService;

@RestController
public class MediaController {

	@Autowired
	private MediaService mediaService;
	
	@GetMapping("/media")
	public Iterable<Media> fetchMediaList() {
		return mediaService.findAllMedia();
	}
	
	@GetMapping("/media/{slug}")
	public Media findMediaById(@PathVariable("id") Long id) {
		Optional<Media> optMedia = mediaService.findById(id);
		return optMedia.get();
	}
	
	@PostMapping(value = "/media", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public Media createMedia(
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile multipartFile
		) throws IOException {
		Media media = new Media();
		media.setTitle(title);
		media.setDescription(description);
		mediaService.save(media, multipartFile);		
		
		return null;
	}

}
