package com.henrik.dvd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.henrik.service.createcollectible.boundary.CreateCollectibleInputBoundary;
import com.henrik.service.createcollectible.entity.CollectibleBookEntity;
import com.henrik.service.createcollectible.entity.CollectibleDVDEntity;
import com.henrik.service.createcollectible.entity.CollectibleEntity;
import com.henrik.service.createcollectible.entity.CollectibleType;
import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;

@Component("DvdBean")
@Scope("request")
public class DvdBackingBean{
	
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
		requestModel.setCollectible(createCollectibleFromDvdModel());
		interactor.createCollectible(requestModel);
		return "createdCollectible.xhtml";
	}

	private CollectibleEntity createCollectibleFromDvdModel() {
		CollectibleEntity entity = null;
		if(CollectibleType.BOOK.getCode().equals(dvdModel.getCollectibleType())) {
			entity = new CollectibleBookEntity(dvdModel.getName(), dvdModel.getDescription());
		} else if(CollectibleType.DVD.getCode().equals(dvdModel.getCollectibleType())) {
			entity = new CollectibleDVDEntity(dvdModel.getName(), dvdModel.getDescription());
		}
		return entity;
	}

	
	
}
