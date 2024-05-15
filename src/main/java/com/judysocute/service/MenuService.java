package com.judysocute.service;

import java.util.Optional;

import com.judysocute.model.Menu;

public interface MenuService {

	
	// read operation
	Iterable<Menu> findAllMenus();
	
	Optional<Menu> findBySlug(String slug);
	
	void save(Menu menu);

}
