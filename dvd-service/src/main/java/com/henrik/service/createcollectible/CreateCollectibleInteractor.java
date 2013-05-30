package com.henrik.service.createcollectible;

import org.springframework.stereotype.Service;

import com.henrik.service.createcollectible.boundary.CreateCollectibleInputBoundary;
import com.henrik.service.createcollectible.boundary.CreateCollectibleOutputBoundary;
import com.henrik.service.createcollectible.entity.CollectibleBookEntity;
import com.henrik.service.createcollectible.entity.CollectibleDVDEntity;
import com.henrik.service.createcollectible.entity.CollectibleEntity;
import com.henrik.service.createcollectible.gateway.CreateCollectibleDatabaseGateway;
import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;
import com.henrik.service.createcollectible.model.CreateCollectibleResponseModel;

@Service("CreateCollectibleInteractor")
public class CreateCollectibleInteractor implements
		CreateCollectibleInputBoundary {
	
	private CreateCollectibleDatabaseGateway database;
	private CreateCollectibleOutputBoundary outputBoundary;

	public void createCollectible(CreateCollectibleRequestModel requestModel) {
		CollectibleEntity collectible = null;
		if(requestModel.getCollectible() instanceof CollectibleBookEntity) {
			collectible = new CollectibleBookEntity(requestModel.getCollectible().getName(), requestModel.getCollectible().getDescription());
			database.storeCollectible(collectible);
		} else if(requestModel.getCollectible() instanceof CollectibleDVDEntity) {
			collectible = new CollectibleDVDEntity(requestModel.getCollectible().getName(), requestModel.getCollectible().getDescription());
			database.storeCollectible(collectible);
		} else {
			collectible = CollectibleEntity.NULL_OBJECT;
		}
		CreateCollectibleResponseModel response = new CreateCollectibleResponseModel();
		response.setEntity(collectible);
		outputBoundary.handleCreateCollectibleResult(response);
	}

}
