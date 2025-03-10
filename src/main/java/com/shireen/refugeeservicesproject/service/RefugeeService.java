package com.shireen.refugeeservicesproject.service;

import com.shireen.refugeeservicesproject.model.Refugee;
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
                    refugee.setFirst_name(updatedRefugee.getFirst_name());
                    refugee.setLast_name(updatedRefugee.getLast_name());
                    refugee.setDate_of_birth(updatedRefugee.getDate_of_birth());
                    refugee.setEmail(updatedRefugee.getEmail());
                    refugee.setPhone(updatedRefugee.getPhone());
                    refugee.setAddress(updatedRefugee.getAddress());
                    refugee.setCountry_of_origin(updatedRefugee.getCountry_of_origin());
                    refugee.setRefugeeId(updatedRefugee.getRefugeeId());
                    refugee.setArea(updatedRefugee.getArea());
                    return refugeeRepository.save(refugee);
                })
                .orElseThrow(() -> new RuntimeException("Refugee not found"));
    }

    public Refugee saveRefugee(Refugee refugee) {
        return refugeeRepository.save(refugee);
    }

    //public void saveRefugee(Refugee refugee) {
    //}
}
