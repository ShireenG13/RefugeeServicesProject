package com.shireen.refugeeservicesproject.service;

import com.shireen.refugeeservicesproject.model.Aide;
import com.shireen.refugeeservicesproject.repository.AideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AideService {

    @Autowired
    private AideRepository aideRepository;

    public List<Aide> getAllAides() {
        return aideRepository.findAll();
    }

    public Optional<Aide> getAideById(Long id) {
        return aideRepository.findById(id);
    }

    public Aide createAide(Aide aide) {
        return aideRepository.save(aide);
    }

    public void deleteAide(Long id) {
        aideRepository.deleteById(id);
    }

    public Aide updateAide(Long id, Aide updatedAide) {
        return aideRepository.findById(id)
                .map(aide -> {
                    aide.setAideType(updatedAide.getAideType());
                    aide.setAideDate(updatedAide.getAideDate());
                    aide.setNotes(updatedAide.getNotes());
                    aide.setRefugee(updatedAide.getRefugee());
                    aide.setVolunteer(updatedAide.getVolunteer());
                    aide.setStatus(updatedAide.getStatus());
                    return aideRepository.save(aide);
                })
                .orElseThrow(() -> new RuntimeException("Aide not found"));
    }
}
