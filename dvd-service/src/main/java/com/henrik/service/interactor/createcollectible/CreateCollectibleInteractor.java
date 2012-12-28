package com.henrik.service.interactor.createcollectible;

public class CreateCollectibleInteractor implements
		CreateCollectibleInputBoundary {
	
	private CreateCollectibleOutputBoundary outputBoundary;

	public void createCollectible(CreateCollectibleRequestModel requestModel) {
		CollectibleEntity collectible = new CollectibleEntity(requestModel.getName(), requestModel.getDescription());
		CreateCollectibleResponseModel response = new CreateCollectibleResponseModel();
		response.setId(1);
		response.setName(collectible.getName());
		response.setDescription(collectible.getDescription());
		outputBoundary.handleCreateCollectibleResult(response);
	}

}
