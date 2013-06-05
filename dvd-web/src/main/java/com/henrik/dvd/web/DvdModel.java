package com.henrik.dvd.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.henrik.service.createcollectible.entity.CollectibleEntity;


@Component("DvdModel")
@Scope("session")
public class DvdModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<CollectibleEntity> entities = new ArrayList<CollectibleEntity>();

	public Collection<CollectibleEntity> getEntities() {
		return entities;
	}

	public void setEntities(Collection<CollectibleEntity> entities) {
		this.entities = entities;
	}
	
	public void addEntity(CollectibleEntity entity) {
		this.entities.add(entity);
	}
	
}
