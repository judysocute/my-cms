package com.judysocute.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "menus")
public class Menu {

	@Id
	private String slug;
	
	private String title;

	private String icon;

	private String description;
	
	// ---------------------------------

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
