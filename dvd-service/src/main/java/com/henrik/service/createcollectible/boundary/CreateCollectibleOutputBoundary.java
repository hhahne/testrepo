package com.henrik.service.createcollectible.boundary;

import com.henrik.service.createcollectible.model.CreateCollectibleResponseModel;

public interface CreateCollectibleOutputBoundary {
	public abstract void handleCreateCollectibleResult(CreateCollectibleResponseModel responseModel);
		
}
