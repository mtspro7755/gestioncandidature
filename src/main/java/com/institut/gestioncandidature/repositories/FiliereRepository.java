package com.institut.gestioncandidature.repositories;

import com.institut.gestioncandidature.models.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
}
