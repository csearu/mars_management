package com.example.mars;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.mars.model.Resource;
import com.example.mars.repository.ResourceRepository;
import com.example.mars.service.ResourceService;

import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ResourceServiceTest {

    @Mock
    private ResourceRepository resourceRepository;  // Mock the repository

    @InjectMocks
    private ResourceService resourceService;  // Inject mocks into the service

    @Test
    public void testUpdateResource() {
        // Arrange
        Resource existingResource = new Resource();
        existingResource.setId(1L);
        existingResource.setName("Oxygen Tank");
        existingResource.setQuantity(50.0);

        when(resourceRepository.findById(1L)).thenReturn(Optional.of(existingResource));
        when(resourceRepository.save(any(Resource.class))).thenReturn(existingResource);

        // Act
        Resource updatedResource = resourceService.updateResource(1L, existingResource);

        // Assert
        assertNotNull(updatedResource);
        assertEquals("Oxygen Tank", updatedResource.getName());
        assertEquals(50.0, updatedResource.getQuantity());
        verify(resourceRepository, times(1)).save(any(Resource.class));
    }
}
