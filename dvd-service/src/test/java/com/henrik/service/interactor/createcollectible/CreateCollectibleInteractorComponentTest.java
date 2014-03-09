package com.henrik.service.interactor.createcollectible;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.henrik.service.createcollectible.CreateCollectibleInteractor;
import com.henrik.service.createcollectible.boundary.CreateCollectibleOutputBoundary;
import com.henrik.service.createcollectible.entity.CollectibleBookEntity;
import com.henrik.service.createcollectible.entity.CollectibleDVDEntity;
import com.henrik.service.createcollectible.entity.CollectibleEntity;
import com.henrik.service.createcollectible.gateway.CreateCollectibleInMemoryDatabaseGateway;
import com.henrik.service.createcollectible.model.CollectibleBookRequest;
import com.henrik.service.createcollectible.model.CollectibleDVDRequest;
import com.henrik.service.createcollectible.model.CollectibleRequest;
import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;

/**
 * Should test the entire business layer with automated tests using mocks for all external points (layers above this service layer and so on)
 * 
 * @author Henrik Hahne
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CreateCollectibleInteractorComponentTest {
	
	private CreateCollectibleInteractor interactor;

	@Mock
	private CreateCollectibleOutputBoundary outputBoundaryMock;
	
	private CreateCollectibleInMemoryDatabaseGateway database = new CreateCollectibleInMemoryDatabaseGateway();
	
	@Before
	public void setUp() {
		interactor = new CreateCollectibleInteractor();
		
		ReflectionTestUtils.setField(interactor, "database", database);
		ReflectionTestUtils.setField(interactor, "outputBoundary", outputBoundaryMock);
	}
	
	@Test
	public void shouldCreateDVDCollectible() {
		CreateCollectibleRequestModel dvdModel = createRequestModel(createDVDRequest());
		interactor.createCollectible(dvdModel);
		
		assertNotNull(database.getAllCollectibles());
		assertTrue(database.getAllCollectibles().size() ==1);
		CollectibleEntity returnedEntity = database.getAllCollectibles().iterator().next();
		assertTrue(returnedEntity instanceof CollectibleDVDEntity);
		assertCollectibleEntity(returnedEntity, "Test", "Test description");
	}
	
	@Test
	public void shouldCreateBookCollectible() {
		CreateCollectibleRequestModel bookModel = createRequestModel(createBookRequest());
		interactor.createCollectible(bookModel);
		
		assertNotNull(database.getAllCollectibles());
		assertTrue(database.getAllCollectibles().size() ==1);
		CollectibleEntity returnedEntity = database.getAllCollectibles().iterator().next();
		assertTrue(returnedEntity instanceof CollectibleBookEntity);
		assertCollectibleEntity(returnedEntity, "TestBook", "Test description");
	}

	
	@Test
	public void shouldNotCreateDuplicateEntities() {
		CreateCollectibleRequestModel dvdModel = createRequestModel(createDVDRequest());
		CreateCollectibleRequestModel dvdDuplicate = createRequestModel(createDVDRequest());
		interactor.createCollectible(dvdModel);
		interactor.createCollectible(dvdDuplicate);
		Collection<CollectibleEntity> returnedEntities = database.getAllCollectibles();
		assertNotNull(returnedEntities);
		assertTrue(returnedEntities.size() == 1);
		assertCollectibleEntity(returnedEntities.iterator().next(), "Test", "Test description");
	}
	
	private void assertCollectibleEntity(CollectibleEntity returnedEntity, String name, String description) {
		assertTrue(returnedEntity.getName().equals(name));
		assertTrue(returnedEntity.getDescription().equals(description));
	}

	
	private CreateCollectibleRequestModel createRequestModel(CollectibleRequest request) {
		CreateCollectibleRequestModel dvdModel = new CreateCollectibleRequestModel();
		dvdModel.setCollectibleRequest(request);
		return dvdModel;
	}

	private CollectibleDVDRequest createDVDRequest() {
		return new CollectibleDVDRequest("Test", "Test description", 130);
	}
	
	private CollectibleBookRequest createBookRequest() {
		return new CollectibleBookRequest("TestBook", "Test description", 300);
	}
 
}
