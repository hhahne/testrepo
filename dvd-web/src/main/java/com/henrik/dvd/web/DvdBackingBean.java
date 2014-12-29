package com.henrik.dvd.web;

import com.henrik.service.createcollectible.boundary.CreateCollectibleInputBoundary;
import com.henrik.service.createcollectible.entity.CollectibleType;
import com.henrik.service.createcollectible.model.CollectibleBookRequest;
import com.henrik.service.createcollectible.model.CollectibleDVDRequest;
import com.henrik.service.createcollectible.model.CollectibleRequest;
import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("DvdBean")
@Scope("request")
public class DvdBackingBean {
	
	@Autowired
	private DvdModel dvdModel; 
	
	@Autowired
	@Qualifier("createCollectibleInteractor")
	private CreateCollectibleInputBoundary interactor;
	
	public String printMessage() {
		return "Hei from backing bean";
	}

	public String addEntityToModel() {
		CreateCollectibleRequestModel requestModel = new CreateCollectibleRequestModel();
		requestModel.setCollectibleRequest(createCollectibleFromDvdModel());
		interactor.createCollectible(requestModel);
		return "createdCollectible.xhtml";
	}

	private CollectibleRequest createCollectibleFromDvdModel() {
		CollectibleRequest request = null;
		if(CollectibleType.BOOK.getCode().equals(dvdModel.getCollectibleType())) {
			request = new CollectibleBookRequest(dvdModel.getName(), dvdModel.getDescription(), 0);
		} else if(CollectibleType.DVD.getCode().equals(dvdModel.getCollectibleType())) {
			request = new CollectibleDVDRequest(dvdModel.getName(), dvdModel.getDescription(), 0);
		}
		return request;
	}

	
}
