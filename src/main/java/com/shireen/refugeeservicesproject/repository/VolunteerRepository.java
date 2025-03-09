package com.shireen.refugeeservicesproject.repository;

import com.shireen.refugeeservicesproject.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
