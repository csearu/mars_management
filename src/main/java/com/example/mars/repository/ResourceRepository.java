package com.example.mars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import com.example.mars.model.Resource;

import jakarta.persistence.LockModeType;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Resource> findById(Long id);

    // Custom query to find all resources below a certain quantity threshold
    List<Resource> findByQuantityLessThan(double threshold);

    // Custom query to find all resources sorted by consumption rate
    List<Resource> findAllByOrderByConsumptionRateDesc();

    // Custom query to find resources by their type
    List<Resource> findByType(String type);
}
