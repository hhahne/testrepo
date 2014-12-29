package com.henrik.dvd.web;

import com.henrik.service.createcollectible.boundary.CreateCollectibleOutputBoundary;
import com.henrik.service.createcollectible.model.CreateCollectibleResponseModel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.faces.context.FacesContext;

/**
 * This class will be called as a "callback" from the service layer BEFORE the main method in the web controller returns. Its job is to process
 * all the return values from the interactor in the service layer calling it in a delivery agnostic way. In our case, that means populating the web model for the use case.
 * 
 * Typical flow: 
 * 1. XHTML 
 * 2. Some java method in a *BackingBean 
 * 3. Some method on an input boundary (implemented in service layer) that potentially does fun stuff.
 * 4. The interactor implementing the input boundary calls the output boundary (this class) to handle the result from the operation
 * 5. The output boundary (this class) updates the web model
 * 6. Control is shipped back to the Backing Bean which will typically return a String for the xhtml page to render...
 * 
 * Also note that Autowiring the model will NOT work due to it being referenced by the service (interactor) and when the spring container starts the 
 * model has not been initialized yet. The model is initialized when the BackingBean is called the first time which is AFTER the instantiation of the interactor.
 * Therefore we have to manually fetch it here from the context...
 * @author Henrik Hahne
 *
 */
@Component("createCollectibleOutputBoundary")
public class CreateCollectibleOutputBoundaryImpl implements CreateCollectibleOutputBoundary {

	//@Autowired
	private DvdModel dvdModel; 
	
	@Override
	public void handleCreateCollectibleResult(
			CreateCollectibleResponseModel responseModel) {
		WebApplicationContext appContext = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		dvdModel = (DvdModel) appContext.getBean("DvdModel");
		System.out.println("Output boundary called !");
		dvdModel.addEntity(responseModel.getEntity());
	}
	
}
