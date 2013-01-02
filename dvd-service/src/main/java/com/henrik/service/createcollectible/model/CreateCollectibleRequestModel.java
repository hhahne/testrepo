package com.henrik.service.createcollectible.model;

import com.henrik.service.createcollectible.entity.CollectibleEntity;

public class CreateCollectibleRequestModel {
	private String type;
	private CollectibleEntity collectible;
	

	public String getType() {
		return type;
	}

	public void setCollectible(CollectibleEntity collectible) {
		this.collectible = collectible;
	}

	public CollectibleEntity getCollectible() {
		return collectible;
	}
	
	
	
	
}
