package com.henrik.service.createcollectible.gateway;

import com.henrik.service.createcollectible.entity.CollectibleEntity;

/**
 * Interface describing the operations the database will be able to perform.
 * 
 * @author Henrik Hahne
 *
 */
public interface CreateCollectibleDatabaseGateway {
	public int storeCollectible(CollectibleEntity entity);
}
