package com.prueba.civa.backendCiva.repository;

import com.prueba.civa.backendCiva.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

}
