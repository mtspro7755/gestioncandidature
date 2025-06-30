package com.institut.gestioncandidature.services;


import com.institut.gestioncandidature.models.Candidat;
import com.institut.gestioncandidature.models.Filiere;
import com.institut.gestioncandidature.repositories.CandidatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidatService {
    private final CandidatRepository candidatRepository;


    public List<Candidat> getAll() {
        return candidatRepository.findAll();
    }


    public Optional<Candidat> getById(Long id) {
        return candidatRepository.findById(id);
    }


    public void deleteById(Long id) {
        candidatRepository.deleteById(id);
    }

    public Candidat save(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    public Candidat update(Long id,Candidat updatedCandidat) {
        Candidat candidat = candidatRepository.findById(id).get();

        candidat.setNom(updatedCandidat.getNom());
        candidat.setPrenom(updatedCandidat.getPrenom());
        candidat.setEmail(updatedCandidat.getEmail());
        candidat.setTelephone(updatedCandidat.getTelephone());
        candidat.setCvUrl(updatedCandidat.getCvUrl());


        return candidatRepository.save(candidat);
    }
}
