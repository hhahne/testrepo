package com.henrik.service.createcollectible.boundary;

import com.henrik.service.createcollectible.model.CreateCollectibleResponseModel;

public interface CreateCollectibleOutputBoundary {
	void handleCreateCollectibleResult(CreateCollectibleResponseModel responseModel);
		
}
