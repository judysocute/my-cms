package com.judysocute.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.judysocute.exceptions.StorageException;
import com.judysocute.model.Media;
import com.judysocute.repository.MediaRepository;

@Service
public class MediaServiceImpl implements MediaService {
	
	@Autowired private MediaRepository mediaRepository;
	@Autowired ResourceLoader resourceLoader;
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
			Path availableFilePath = getAvailableFilePath(destinationFile);

			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, availableFilePath, StandardCopyOption.REPLACE_EXISTING);
				media.setImagePath(availableFilePath.toString());
				mediaRepository.save(media);
			}
		}
		catch (IOException e) {
			throw new StorageException("Failed to store file.", e);
		}
	}
	
	private Path getAvailableFilePath(Path filePath) {
		if (!Files.exists(filePath)) {
			return filePath;
		}
		File file = filePath.toFile();
		String name = file.getName();
        String baseName = name.substring(0, name.lastIndexOf('.'));
        String extension = name.substring(name.lastIndexOf('.'));
		
        int counter = 1;
        String newFileName;
        do {
            newFileName = baseName + "_" + counter + extension;
            file = new File(newFileName);
            counter++;
        } while (file.exists());
        
        return Path.of(newFileName);
	}
}
