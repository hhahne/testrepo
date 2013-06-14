package com.henrik.service.createcollectible.entity;

public enum CollectibleType {
	BOOK("Book"), 
	DVD("Dvd");

	private String code;
	
	private CollectibleType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
}
