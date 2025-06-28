package com.institut.gestioncandidature.repositories;

import com.institut.gestioncandidature.models.Candidature;
import com.institut.gestioncandidature.models.StatutCandidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
    List<Candidature> findByStatut(StatutCandidature statut);
}
