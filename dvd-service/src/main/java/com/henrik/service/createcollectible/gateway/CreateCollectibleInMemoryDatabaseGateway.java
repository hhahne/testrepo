package com.henrik.service.createcollectible.gateway;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.henrik.service.createcollectible.entity.CollectibleEntity;

@Service("CreateCollectibleInMemoryDatabaseGateway")
public class CreateCollectibleInMemoryDatabaseGateway implements CreateCollectibleDatabaseGateway {
	
	private static Integer databaseId = 1;
	public Collection<CollectibleEntity> entities = new HashSet<CollectibleEntity>(); 

	public int storeCollectible(CollectibleEntity entity) {
		entity.setId(databaseId++);
		entities.add(entity);
		databaseId++;
		return databaseId;
	}

	public Collection<CollectibleEntity> getAllCollectibles() {
		return entities;
	}
	
	

}
