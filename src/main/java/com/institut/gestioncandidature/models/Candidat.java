package com.institut.gestioncandidature.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidat {
    @Id
    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String telephone;

    private String cvUrl;

}
