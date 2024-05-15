package com.judysocute.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.judysocute.model.Menu;
import com.judysocute.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public Iterable<Menu> findAllMenus() {
		return menuRepository.findAll();
	}

	@Override
	public Optional<Menu> findBySlug(String slug) {
		return menuRepository.findById(slug);
	}

	@Override
	public void save(Menu menu) {
		menuRepository.save(menu);
	}
	
	
}
