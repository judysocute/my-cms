package com.judysocute.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.judysocute.exceptions.StorageException;
import com.judysocute.model.Media;
import com.judysocute.repository.MediaRepository;

@Service
public class MediaServiceImpl implements MediaService {
	
	@Autowired private MediaRepository mediaRepository;
	private final Path rootLocation = Path.of("");
	

	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		}
		catch (IOException e) {
			throw new StorageException("Could not initialize storage", e);
		}
	}
	

	@Override
	public Iterable<Media> findAllMedia() {
		return mediaRepository.findAll();
	}

	@Override
	public Optional<Media> findById(Long id) {
		return mediaRepository.findById(id);
	}

	@Override
	public void save(Media media, MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file.");
			}

			String fileName = file.getOriginalFilename();
			Path destinationFile = this.rootLocation.resolve(
					Paths.get(fileName))
					.normalize().toAbsolutePath();
			System.out.println("rootLocation => " + this.rootLocation.toString());
			System.out.println("Paths.get(fileName) => " + Paths.get(fileName).toString());
			System.out.println("destinationFile => " + destinationFile.toString());
			

			if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
				// This is a security check
				throw new StorageException(
						"Cannot store file outside current directory.");
			}

			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
				media.setImagePath(destinationFile.toString());
				mediaRepository.save(media);
			}
		}
		catch (IOException e) {
			throw new StorageException("Failed to store file.", e);
		}
	}


//		@Override
//	public void init() {
//		try {
//			Files.createDirectories(rootLocation);
//		}
//		catch (IOException e) {
//			throw new StorageException("Could not initialize storage", e);
//		}
//		
//	}

}
