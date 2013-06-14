package com.henrik.dvd.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.henrik.service.createcollectible.entity.CollectibleEntity;


@Component("DvdModel")
@Scope("session")
public class DvdModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CollectibleEntity> entities = new ArrayList<CollectibleEntity>();
	
	private String collectibleType;
	private String name;
	private String description;
	

	public List<CollectibleEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<CollectibleEntity> entities) {
		this.entities = entities;
	}
	
	public void addEntity(CollectibleEntity entity) {
		this.entities.add(entity);
	}

	public String getCollectibleType() {
		return collectibleType;
	}

	public void setCollectibleType(String collectibleType) {
		this.collectibleType = collectibleType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	
}
