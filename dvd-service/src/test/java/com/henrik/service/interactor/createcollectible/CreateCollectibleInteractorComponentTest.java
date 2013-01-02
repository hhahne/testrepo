package com.henrik.service.interactor.createcollectible;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.henrik.service.createcollectible.CreateCollectibleInteractor;
import com.henrik.service.createcollectible.boundary.CreateCollectibleOutputBoundary;
import com.henrik.service.createcollectible.entity.CollectibleDVDEntity;
import com.henrik.service.createcollectible.entity.CollectibleEntity;
import com.henrik.service.createcollectible.gateway.CreateCollectibleDatabaseGateway;
import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;

/**
 * Should test the entire business layer with automated tests using mocks for all eternal points (layers above this service layer, web services, file system interactions, databases and so on)
 * 
 * @author Henrik Hahne
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CreateCollectibleInteractorComponentTest {

	@Mock
	private CreateCollectibleOutputBoundary outputBoundaryMock;
	
	private CreateCollectibleInMemoryDatabaseGateway database = new CreateCollectibleInMemoryDatabaseGateway();
	
	@Test
	public void shouldCreateDVDCollectible() {
		CreateCollectibleInteractor interactor = new CreateCollectibleInteractor();
		CreateCollectibleRequestModel dvdModel = createDVDRequestModel();
		ReflectionTestUtils.setField(interactor, "database", database);
		ReflectionTestUtils.setField(interactor, "outputBoundary", outputBoundaryMock);
		assertTrue(database.map.isEmpty());
		interactor.createCollectible(dvdModel);
		assertTrue(database.map.size() == 1);
	}

	private CreateCollectibleRequestModel createDVDRequestModel() {
		CreateCollectibleRequestModel dvdModel = new CreateCollectibleRequestModel();
		dvdModel.setCollectible(createDefaultDVD());
		return dvdModel;
	}

	private CollectibleDVDEntity createDefaultDVD() {
		return new CollectibleDVDEntity("Test", "Test description");
	}
 
}
