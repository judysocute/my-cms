package com.judysocute.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.judysocute.model.Menu;
import com.judysocute.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@GetMapping("/menus")
	public Iterable<Menu> fetchMenuList() {
		return menuService.findAllMenus();
	}
	
	@GetMapping("/menu/{slug}")
	public Menu findMenuBySlug(@PathVariable("slug") String slug) {
		Optional<Menu> optMenu = menuService.findBySlug(slug);
		return optMenu.get();
	}
	
	@PostMapping("/menu")
	public Menu createMenu(@RequestBody Menu menu) {
		menuService.save(menu);
		return menu;
	}

}
