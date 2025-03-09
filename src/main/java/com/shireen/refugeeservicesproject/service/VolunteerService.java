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
                    volunteer.setFirstName(updatedVolunteer.getFirstName());
                    volunteer.setLastName(updatedVolunteer.getLastName());
                    volunteer.setDateOfBirth(updatedVolunteer.getDateOfBirth());
                    volunteer.setEmail(updatedVolunteer.getEmail());
                    volunteer.setPhone(updatedVolunteer.getPhone());
                    volunteer.setAddress(updatedVolunteer.getAddress());
                    volunteer.setAides(updatedVolunteer.getAides());
                    volunteer.setDateOfBirth(updatedVolunteer.getDateOfBirth());
                    volunteer.setContactName(updatedVolunteer.getContactName());
                    volunteer.setContactRel(updatedVolunteer.getContactRel());
                    volunteer.setContactPhone(updatedVolunteer.getContactPhone());
                    return volunteerRepository.save(volunteer);
                })
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
    }
}
