package com.henrik.service.createcollectible.entity;

public class CollectibleEntity {
	private String name;
	private String description;
	
	public static final CollectibleEntity NULL_OBJECT = new CollectibleEntity(null, null);
	
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
