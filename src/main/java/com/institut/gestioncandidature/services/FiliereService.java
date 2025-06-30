package com.institut.gestioncandidature.services;

import com.institut.gestioncandidature.models.Filiere;
import com.institut.gestioncandidature.repositories.FiliereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FiliereService {

    private final FiliereRepository filiereRepository;

    public Filiere create(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    public List<Filiere> getAll() {
        return filiereRepository.findAll();
    }

    public Filiere getById(Long id) {
        return filiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filière non trouvée"));
    }

    public Filiere update(Long id, Filiere updated) {
        Filiere filiere = getById(id);
        filiere.setNom(updated.getNom());
        filiere.setDescription(updated.getDescription());
        filiere.setNiveau(updated.getNiveau());
        return filiereRepository.save(filiere);
    }

    public void delete(Long id) {
        filiereRepository.deleteById(id);
    }
}
