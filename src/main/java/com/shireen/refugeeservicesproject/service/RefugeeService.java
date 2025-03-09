package com.shireen.refugeeservicesproject.service;

import com.shireen.refugeeservicesproject.model.Refugee;
import com.shireen.refugeeservicesproject.model.Volunteer;
import com.shireen.refugeeservicesproject.repository.RefugeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefugeeService {
    @Autowired
    private RefugeeRepository refugeeRepository;

    public List<Refugee> getAllRefugees() {
        return refugeeRepository.findAll();
    }

    public Optional<Refugee> getRefugeeById(Long id) {
        return refugeeRepository.findById(id);
    }

    public Refugee createRefugee(Refugee refugee) {
        return refugeeRepository.save(refugee);
    }

    public void deleteRefugee(Long id) {
        refugeeRepository.deleteById(id);
    }

    public Refugee updateRefugee(Long id, Refugee updatedRefugee) {
        return refugeeRepository.findById(id)
                .map(refugee -> {
                    refugee.setFirstName(updatedRefugee.getFirstName());
                    refugee.setLastName(updatedRefugee.getLastName());
                    refugee.setDateOfBirth(updatedRefugee.getDateOfBirth());
                    refugee.setEmail(updatedRefugee.getEmail());
                    refugee.setPhone(updatedRefugee.getPhone());
                    refugee.setAddress(updatedRefugee.getAddress());
                    refugee.setCountryOfOrigin(updatedRefugee.getCountryOfOrigin());
                    refugee.setFamilyCount(updatedRefugee.getFamilyCount());
                    refugee.setArea(updatedRefugee.getArea());
                    return refugeeRepository.save(refugee);
                })
                .orElseThrow(() -> new RuntimeException("Refugee not found"));
    }

}
