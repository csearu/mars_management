package com.example.mars;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;

import com.example.mars.model.Resource;
import com.example.mars.repository.ResourceRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MarsApplicationTests {

	@Autowired
	private ResourceRepository repository;

	@Test
	public void testGetAllResources() {
		List<Resource> resources = repository.findAll();
		assertFalse(resources.isEmpty());
	}

	@Test
	public void testAddResource() {
		Resource resource = new Resource("Test Resource", 100, 5, "units");
		Resource saved = repository.save(resource);
		assertNotNull(saved.getId());
	}

	@Test
	public void testOptimisticLocking() {
		// Thread 1: Fetch the resource
		Resource resource1 = repository.findById(1L).orElseThrow();
		Resource resource2 = repository.findById(1L).orElseThrow();

		// Thread 1: Update and save
		resource1.setQuantity(50.0);
		repository.save(resource1);

		// Thread 2: Update and save
		resource2.setQuantity(30.0);
		assertThrows(OptimisticLockingFailureException.class, () -> repository.save(resource2));
	}

	@Test
	void contextLoads() {
	}

}
