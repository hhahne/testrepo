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

@RunWith(MockitoJUnitRunner.class)
public class CreateCollectibleInteractorTest {

	private CreateCollectibleInputBoundary createCollectibleInteractor;
	
	@Mock
	CreateCollectibleOutputBoundary outputBoundaryMock;
	
	@Before()
	public void setUp() {
		createCollectibleInteractor = new CreateCollectibleInteractor();
		ReflectionTestUtils.setField(createCollectibleInteractor, "outputBoundary", outputBoundaryMock);
	}	
	
	@Test
	public void shouldCallTheOutputBoundaryWhenCreatingNewCollectible() {
		CreateCollectibleRequestModel request = new CreateCollectibleRequestModel();
		createCollectibleInteractor.createCollectible(request);
		verify(outputBoundaryMock, times(1)).handleCreateCollectibleResult(any(CreateCollectibleResponseModel.class));
	}
	
	@Test
	public void shouldPassTheCorrectValuesWhenCreatingNewCollectible() {
		CreateCollectibleRequestModel request = new CreateCollectibleRequestModel();
		request.setName("Hunt for Red October");
		request.setDescription("The great and exciting movie about the defection of a russian submarine captain.");
		createCollectibleInteractor.createCollectible(request);
		ArgumentCaptor<CreateCollectibleResponseModel> argument = ArgumentCaptor.forClass(CreateCollectibleResponseModel.class);
		verify(outputBoundaryMock, times(1)).handleCreateCollectibleResult(argument.capture());
		assertNotNull(argument.getValue().getName());
		
	}

	
	
}
