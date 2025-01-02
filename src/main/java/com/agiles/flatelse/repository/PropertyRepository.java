package com.agiles.flatelse.repository;

import com.agiles.flatelse.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    // You can add custom queries if needed
}
