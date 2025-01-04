package com.agiles.flatelse.repository;

import com.agiles.flatelse.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Properties, Long> {

}
