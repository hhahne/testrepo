package com.henrik.service.createcollectible.entity;


public class CollectibleBookEntity extends CollectibleEntity {

	private int numberOfPages;
	
	public CollectibleBookEntity(String name, String description) {
		super(name, description);
	}

	public CollectibleBookEntity(String name, String description, int numberOfPages) 
	{
		this(name, description);
		this.numberOfPages = numberOfPages;
		
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
}
