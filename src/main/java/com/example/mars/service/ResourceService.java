package com.example.mars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mars.model.Resource;
import com.example.mars.repository.ResourceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository repository;

    public List<Resource> getAllResources() {
        return repository.findAll();
    }

    public Resource addResource(Resource resource) {
        return repository.save(resource);
    }

    public Resource updateResource(Long id, Resource resource) {
        // Retrieve the existing resource from the database
        Resource existingResource = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        
        // Update the fields of the existing resource with the new values
        existingResource.setName(resource.getName());
        existingResource.setType(resource.getType());
        existingResource.setQuantity(resource.getQuantity());
        existingResource.setConsumptionRate(resource.getConsumptionRate());

        // Save and return the updated resource
        return repository.save(existingResource);
    }

    public void updateResourceConsumption(Long id, double newQuantity) {
        Resource resource = repository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));
        resource.setQuantity(newQuantity);
        repository.save(resource);
    }

    public List<String> getPredictions() {
        List<Resource> resources = repository.findAll();
        return resources.stream()
                .map(resource -> {
                    double hoursLeft = resource.getQuantity() / resource.getConsumptionRate();
                    return String.format("Resource: %s will last approximately %.2f hours", resource.getName(),
                            hoursLeft);
                })
                .collect(Collectors.toList());
    }
}
