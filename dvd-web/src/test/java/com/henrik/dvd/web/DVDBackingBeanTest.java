package com.henrik.dvd.web;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.henrik.service.createcollectible.boundary.CreateCollectibleInputBoundary;

public class DVDBackingBeanTest {
	
	private DvdBackingBean bean;
	private DvdModel model;
	
	@Mock
	private CreateCollectibleInputBoundary inputBoundaryMock;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		bean = new DvdBackingBean();
		model = new DvdModel();
		ReflectionTestUtils.setField(bean, "dvdModel", model);
		ReflectionTestUtils.setField(bean, "interactor", inputBoundaryMock);
	}
	
	@Test
	public void shouldNotReturnNullWhenAddingEntity() {
		createCollectible("Book", "Book 1", "Test book description");
		String result = bean.addEntityToModel();
		assertNotNull(result);
	}


	@Test
	public void shouldNotReturnEmptyStringWhenAddingEntity() {
		createCollectible("Book", "Book 1", "Test book description");
		String result = bean.addEntityToModel();
		assertNotNull(result);
		assertTrue(!result.isEmpty());
	}
	
	@Test
	public void shouldReturnSuccessWhenAddingAnEntitySuccessfully() {
		createCollectible("Book", "Book 1", "Test book description");
		String result = bean.addEntityToModel();
		assertNotNull(result);
		assertTrue(result.equals("createdCollectible.xhtml"));
	}
	
	@Test
	public void shouldReturnSuccessWhenAddingADVDEntitySuccessfully() {
		createCollectible("DVD", "DVD 1", "Test DVD description");
		String result = bean.addEntityToModel();
		assertNotNull(result);
		assertTrue(result.equals("createdCollectible.xhtml"));
	}
	
	private void createCollectible(String collectibleType, String name, String description) {
		model.setCollectibleType(collectibleType);
		model.setName(name);
		model.setDescription(description);
	}
	
}
