package com.institut.gestioncandidature.repositories;

import com.institut.gestioncandidature.models.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
}
