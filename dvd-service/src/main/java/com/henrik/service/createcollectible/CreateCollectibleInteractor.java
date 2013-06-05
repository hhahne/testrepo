package com.henrik.service.createcollectible;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private CreateCollectibleDatabaseGateway database;
	
	@Autowired
	private CreateCollectibleOutputBoundary outputBoundary;

	public void createCollectible(CreateCollectibleRequestModel requestModel) {
		CreateCollectibleResponseModel response = new CreateCollectibleResponseModel();
		if(requestModel.getCollectible() instanceof CollectibleEntity) {
			database.storeCollectible(requestModel.getCollectible());
			response.setEntity(requestModel.getCollectible());
		} else {
			response.setEntity(CollectibleEntity.NULL_OBJECT);
		}
		outputBoundary.handleCreateCollectibleResult(response);
	}

}
