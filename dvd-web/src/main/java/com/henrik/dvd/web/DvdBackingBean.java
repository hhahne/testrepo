package com.henrik.dvd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.henrik.service.createcollectible.boundary.CreateCollectibleInputBoundary;

@Component("DvdBean")
@Scope("request")
public class DvdBackingBean {
	
//	@Autowired
//	private DvdModel model; 
	
//	@Autowired
//	@Qualifier("CreateCollectibleInteractor")
//	private CreateCollectibleInputBoundary interactor;
	
	public String printMessage() {
//		CreateCollectibleRequestModel model = new CreateCollectibleRequestModel();
//		model.setCollectible(new CollectibleDVDEntity("test", "Test"));
//		interactor.createCollectible(model);
		return "Hei from backing bean";
	}

//	@Override
//	public void handleCreateCollectibleResult(
//			CreateCollectibleResponseModel responseModel) {
//		System.out.println("Test");
//	}
//	
	
	
}
