package com.example.mars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mars.model.Resource;
import com.example.mars.repository.ResourceRepository;
import com.example.mars.service.ResourceService;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService service;

    private final ResourceRepository resourceRepository;

    // Constructor injection to initialize the final field
    public ResourceController(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return service.getAllResources();
    }

    // @PostMapping
    // public Resource addResource(@RequestBody Resource resource) {
    // return service.addResource(resource);
    // }

    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        // Save the resource to the database
        Resource savedResource = resourceRepository.save(resource);
        return ResponseEntity.ok(savedResource);
    }

    @PutMapping("/{id}/update")
    public void updateResourceConsumption(@PathVariable Long id, @RequestBody double quantity) {
        service.updateResourceConsumption(id, quantity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody Resource resource) {
        Resource updatedResource = service.updateResource(id, resource);
        return ResponseEntity.ok(updatedResource);
    }

    @GetMapping("/predictions")
    public List<String> getPredictions() {
        return service.getPredictions();
    }
}
