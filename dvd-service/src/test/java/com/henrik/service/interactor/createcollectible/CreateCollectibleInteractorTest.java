package com.henrik.service.interactor.createcollectible;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.henrik.service.createcollectible.CreateCollectibleInteractor;
import com.henrik.service.createcollectible.boundary.CreateCollectibleInputBoundary;
import com.henrik.service.createcollectible.boundary.CreateCollectibleOutputBoundary;
import com.henrik.service.createcollectible.entity.CollectibleBookEntity;
import com.henrik.service.createcollectible.entity.CollectibleDVDEntity;
import com.henrik.service.createcollectible.entity.CollectibleEntity;
import com.henrik.service.createcollectible.gateway.CreateCollectibleDatabaseGateway;
import com.henrik.service.createcollectible.model.CollectibleBookRequest;
import com.henrik.service.createcollectible.model.CollectibleDVDRequest;
import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;
import com.henrik.service.createcollectible.model.CreateCollectibleResponseModel;

@RunWith(MockitoJUnitRunner.class)
public class CreateCollectibleInteractorTest {

	private CreateCollectibleInputBoundary createCollectibleInteractor;
	
	@Mock
	private CreateCollectibleOutputBoundary outputBoundaryMock;
	
	@Mock
	private CreateCollectibleDatabaseGateway databaseMock;
	
	@Before()
	public void setUp() {
		createCollectibleInteractor = new CreateCollectibleInteractor();
		ReflectionTestUtils.setField(createCollectibleInteractor, "outputBoundary", outputBoundaryMock);
		ReflectionTestUtils.setField(createCollectibleInteractor, "database", databaseMock);
	}	
	
	@Test
	public void shouldCreateABookCollectible() {
		CreateCollectibleRequestModel model = new CreateCollectibleRequestModel();
		CollectibleBookRequest book = new CollectibleBookRequest("Hunt for Red October", "Book written by Tom Clancy I reckon", 450);
		model.setCollectibleRequest(book);
		
		createCollectibleInteractor.createCollectible(model);
		
		ArgumentCaptor<CreateCollectibleResponseModel> argument = ArgumentCaptor.forClass(CreateCollectibleResponseModel.class);
		verify(outputBoundaryMock, times(1)).handleCreateCollectibleResult(argument.capture());
		assertNotNull(argument.getValue().getEntity());
		assertTrue(argument.getValue().getEntity() instanceof CollectibleBookEntity);
		verify(databaseMock, times(1)).storeCollectible(any(CollectibleEntity.class));
	}
	
	@Test
	public void shouldCreateADVDCollectible() {
		CreateCollectibleRequestModel model = new CreateCollectibleRequestModel();
		CollectibleDVDRequest dvd = new CollectibleDVDRequest("Hunt for Red October", "Movie version of the Hunt for Red October", 150);
		model.setCollectibleRequest(dvd);
		
		createCollectibleInteractor.createCollectible(model);
		
		ArgumentCaptor<CreateCollectibleResponseModel> argument = ArgumentCaptor.forClass(CreateCollectibleResponseModel.class);
		verify(outputBoundaryMock, times(1)).handleCreateCollectibleResult(argument.capture());
		assertNotNull(argument.getValue().getEntity());
		assertTrue(argument.getValue().getEntity() instanceof CollectibleDVDEntity);
		verify(databaseMock, times(1)).storeCollectible(any(CollectibleEntity.class));
	}	
	
	@Test
	public void shouldNotCreateUnknownCollectibles() {
		CreateCollectibleRequestModel model = new CreateCollectibleRequestModel();
		model.setCollectibleRequest(null);
		createCollectibleInteractor.createCollectible(model);
		verify(databaseMock, times(0)).storeCollectible(any(CollectibleEntity.class));
	}
	
}
