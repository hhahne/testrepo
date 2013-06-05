package com.henrik.dvd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.henrik.service.createcollectible.CreateCollectibleInteractor;
import com.henrik.service.createcollectible.boundary.CreateCollectibleInputBoundary;
import com.henrik.service.createcollectible.boundary.CreateCollectibleOutputBoundary;
import com.henrik.service.createcollectible.entity.CollectibleDVDEntity;
import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;
import com.henrik.service.createcollectible.model.CreateCollectibleResponseModel;

@Component("DvdBean")
@Scope("request")
public class DvdBackingBean{
	
	@Autowired
	private DvdModel dvdModel; 
	
	@Autowired
	@Qualifier("CreateCollectibleInteractor")
	private CreateCollectibleInputBoundary interactor;
	
	public String printMessage() {
		CreateCollectibleRequestModel model = new CreateCollectibleRequestModel();
		model.setCollectible(new CollectibleDVDEntity("test", "Test"));
		interactor.createCollectible(model);
		return "Hei from backing bean Hola";
	}

	
	
}
