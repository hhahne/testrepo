package com.henrik.service.interactor.createcollectible;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

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
import com.henrik.service.createcollectible.model.CreateCollectibleRequestModel;
import com.henrik.service.createcollectible.model.CreateCollectibleResponseModel;

@RunWith(MockitoJUnitRunner.class)
public class CreateCollectibleInteractorTest {

	private CreateCollectibleInputBoundary createCollectibleInteractor;
	
	@Mock
	CreateCollectibleOutputBoundary outputBoundaryMock;
	
	@Mock
	CreateCollectibleDatabaseGateway databaseMock;
	
	@Before()
	public void setUp() {
		createCollectibleInteractor = new CreateCollectibleInteractor();
		ReflectionTestUtils.setField(createCollectibleInteractor, "outputBoundary", outputBoundaryMock);
		ReflectionTestUtils.setField(createCollectibleInteractor, "database", databaseMock);
	}	
	
	@Test
	public void shouldCreateABookCollectible() {
		CreateCollectibleRequestModel model = new CreateCollectibleRequestModel();
		CollectibleEntity book = new CollectibleBookEntity("Hunt for Red October", "Book written by Tom Clancy I reckon");
		model.setCollectible(book);
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
		CollectibleEntity dvd = new CollectibleDVDEntity("Hunt for Red October", "Movie version of the Hunt for Red October");
		model.setCollectible(dvd);
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
		model.setCollectible(null);
		createCollectibleInteractor.createCollectible(model);
		verify(databaseMock, times(0)).storeCollectible(any(CollectibleEntity.class));
	}
	
}
