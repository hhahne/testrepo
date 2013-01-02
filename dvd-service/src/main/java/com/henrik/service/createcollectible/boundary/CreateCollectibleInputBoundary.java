package com.henrik.service.createcollectible.boundary;

import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;

public interface CreateCollectibleInputBoundary {
	public abstract void createCollectible(CreateCollectibleRequestModel requestModel);
}
