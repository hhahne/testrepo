package com.henrik.service.interactor.createcollectible;

import java.util.HashMap;

import com.henrik.service.createcollectible.entity.CollectibleEntity;
import com.henrik.service.createcollectible.gateway.CreateCollectibleDatabaseGateway;

public class CreateCollectibleInMemoryDatabaseGateway implements CreateCollectibleDatabaseGateway {
	
	private static Integer databaseId = 1;
	public HashMap<Integer, CollectibleEntity> map = new HashMap<Integer, CollectibleEntity>(); 

	public int storeCollectible(CollectibleEntity entity) {
		map.put(databaseId, entity);
		databaseId++;
		return databaseId;
	}

}
