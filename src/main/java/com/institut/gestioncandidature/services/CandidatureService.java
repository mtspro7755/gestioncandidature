package com.institut.gestioncandidature.services;


import com.institut.gestioncandidature.models.Candidature;
import com.institut.gestioncandidature.repositories.CandidatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidatureService {
    private final CandidatureRepository candidatureRepository;
    /*private final CandidatRepository candidatRepository;
    private final FiliereRepository filiereRepository;*/

    public Candidature save(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    public List<Candidature> getAll() {

        return candidatureRepository.findAll();
    }

    public Optional<Candidature> findById(Long id) {

        return candidatureRepository.findById(id);
    }

    public void deleteById(Long id) {

        candidatureRepository.findById(id);
    }






}
