package com.henrik.service.createcollectible.model;

public class CollectibleBookRequest extends CollectibleRequest {
	private int length;

	public CollectibleBookRequest(String name, String description, int length) {
		this.name = name;
		this.description = description;
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
}
