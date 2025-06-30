package com.institut.gestioncandidature.services;

import com.institut.gestioncandidature.dto.CandidatureRequest;
import com.institut.gestioncandidature.models.Candidat;
import com.institut.gestioncandidature.models.Candidature;
import com.institut.gestioncandidature.models.Filiere;
import com.institut.gestioncandidature.models.StatutCandidature;
import com.institut.gestioncandidature.repositories.CandidatRepository;
import com.institut.gestioncandidature.repositories.CandidatureRepository;
import com.institut.gestioncandidature.repositories.FiliereRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidatureService {
    private final CandidatureRepository candidatureRepository;
    private final CandidatRepository candidatRepository;
    private final FiliereRepository filiereRepository;

    public Candidature save(CandidatureRequest request) {
        Filiere filiere = filiereRepository.findById(request.getFiliereId())
                .orElseThrow(() -> new EntityNotFoundException("Filiere not found"));

        Candidat candidat = Candidat.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .telephone(request.getTelephone())
                .email(request.getEmail())
                .cvUrl(request.getCvUrl())
                .build();


        Candidature candidature= Candidature.builder()
                .dateDepot(LocalDateTime.now())
                .statut(StatutCandidature.EN_ATTENTE)
                .candidat(candidat)
                .filiere(filiere)
                .build();


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



    public Candidature update(Long id, CandidatureRequest request) {

        Candidature existingCandidature = candidatureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Candidature avec l'ID " + id + " introuvable pour la mise à jour."));


        Filiere filiere = filiereRepository.findById(request.getFiliereId())
                .orElseThrow(() -> new EntityNotFoundException("Filière avec l'ID " + request.getFiliereId() + " introuvable."));

        Candidat existingCandiat=candidatRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Candidat avec l'ID " + id + " introuvable pour la mise à jour."));

        existingCandiat.setNom(request.getNom());
        existingCandiat.setPrenom(request.getPrenom());
        existingCandiat.setTelephone(request.getTelephone());
        existingCandiat.setEmail(request.getEmail());
        existingCandiat.setCvUrl(request.getCvUrl());

        existingCandidature.setFiliere(filiere);

        return candidatureRepository.save(existingCandidature);
    }


}
