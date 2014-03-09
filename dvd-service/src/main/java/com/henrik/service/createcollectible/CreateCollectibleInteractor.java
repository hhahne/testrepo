package com.henrik.service.createcollectible;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrik.service.createcollectible.boundary.CreateCollectibleInputBoundary;
import com.henrik.service.createcollectible.boundary.CreateCollectibleOutputBoundary;
import com.henrik.service.createcollectible.entity.CollectibleBookEntity;
import com.henrik.service.createcollectible.entity.CollectibleDVDEntity;
import com.henrik.service.createcollectible.entity.CollectibleEntity;
import com.henrik.service.createcollectible.gateway.CreateCollectibleDatabaseGateway;
import com.henrik.service.createcollectible.model.CollectibleBookRequest;
import com.henrik.service.createcollectible.model.CollectibleDVDRequest;
import com.henrik.service.createcollectible.model.CollectibleRequest;
import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;
import com.henrik.service.createcollectible.model.CreateCollectibleResponseModel;

@Service("createCollectibleInteractor")
public class CreateCollectibleInteractor implements
		CreateCollectibleInputBoundary {
	
	@Autowired
	private CreateCollectibleDatabaseGateway database;
	
	@Autowired
	private CreateCollectibleOutputBoundary outputBoundary;

	public void createCollectible(CreateCollectibleRequestModel requestModel) {
		CreateCollectibleResponseModel response = new CreateCollectibleResponseModel();
		if(requestModel.getCollectibleRequest() instanceof CollectibleRequest) {
			CollectibleEntity entity = createCollectibleEntityFromRequest(requestModel.getCollectibleRequest());
			database.storeCollectible(entity);
			response.setEntity(entity);
		} else {
			response.setEntity(CollectibleEntity.NULL_OBJECT);
		}
		outputBoundary.handleCreateCollectibleResult(response);
	}

	private CollectibleEntity createCollectibleEntityFromRequest(
			CollectibleRequest collectibleRequest) {
		if(collectibleRequest instanceof CollectibleBookRequest) {
			CollectibleBookRequest bookRequest = (CollectibleBookRequest) collectibleRequest;
			CollectibleEntity entity = new CollectibleBookEntity(bookRequest.getName(), bookRequest.getDescription(), bookRequest.getLength());
			return entity;
		} else {
			CollectibleDVDRequest dvdRequest = (CollectibleDVDRequest) collectibleRequest;
			CollectibleEntity entity = new CollectibleDVDEntity(dvdRequest.getName(), dvdRequest.getDescription(), dvdRequest.getRunningLength());
			return entity;
		}
	}

}
