package com.judysocute.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "posts")
public class Post {
	
	@Id
	private String slug;
	
	private String title;
	
	@OneToOne
    @JoinColumn(name = "image_id")
	private Media heroImage;
	
	private String description;
	
	private String body;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Author author;
	
	private Date publishDate;
	
	private Set<String> tags;
	
	private boolean isFeature;
	
	// ---------------------------------------------------
	
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
	
	public Media getHeroImage() {
		return heroImage;
	}
	
	public void setHeroImage(Media heroImage) {
		this.heroImage = heroImage;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public Set<String> getTags() {
		return tags;
	}
	
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	public boolean getIsFeature() {
		return isFeature;
	}
	
	public void setIsFeature(boolean isFeature) {
		this.isFeature = isFeature;
	}
	
}
