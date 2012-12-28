package com.henrik.service.interactor.createcollectible;

public class CollectibleEntity {
	private String name;
	private String description;

	
	public CollectibleEntity(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
}
