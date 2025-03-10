package com.shireen.refugeeservicesproject.service;

import com.shireen.refugeeservicesproject.model.Item;
import com.shireen.refugeeservicesproject.model.Volunteer;
import com.shireen.refugeeservicesproject.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    public Optional<Volunteer> getVolunteerById(Long id) {
        return volunteerRepository.findById(id);
    }

    public Volunteer createVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    public void deleteVolunteer(Long id) {
        volunteerRepository.deleteById(id);
    }

    public Volunteer updateVolunteer(Long id, Volunteer updatedVolunteer) {
        return volunteerRepository.findById(id)
                .map(volunteer -> {
                    volunteer.setFirst_name(updatedVolunteer.getFirst_name());
                    volunteer.setLast_name(updatedVolunteer.getLast_name());
                    volunteer.setDate_of_birth(updatedVolunteer.getDate_of_birth());
                    volunteer.setEmail(updatedVolunteer.getEmail());
                    volunteer.setPhone(updatedVolunteer.getPhone());
                    volunteer.setAddress(updatedVolunteer.getAddress());
                    volunteer.setAides(updatedVolunteer.getAides());
                    volunteer.setEmergency_contact(updatedVolunteer.getEmergency_contact());
                    volunteer.setRelationship(updatedVolunteer.getRelationship());
                    volunteer.setContact_phone(updatedVolunteer.getContact_phone());
                    return volunteerRepository.save(volunteer);
                })
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
    }
}
