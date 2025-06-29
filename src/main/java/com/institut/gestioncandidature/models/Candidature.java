package com.institut.gestioncandidature.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidature {
    @Id
    private Long id;
    private LocalDateTime dateDepot;

    @Enumerated(EnumType.STRING)
    private StatutCandidature statut;

    @ManyToOne
    private Candidat candidat;

    @ManyToOne
    private Filiere filiere;





}
