package com.shireen.refugeeservicesproject.repository;

import com.shireen.refugeeservicesproject.model.Refugee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefugeeRepository extends JpaRepository<Refugee, Long> {

}
