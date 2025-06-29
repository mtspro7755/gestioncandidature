package com.institut.gestioncandidature.dto;

import lombok.Data;

@Data
public class CandidatureRequest {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String cvUrl;
    private Long filiereId;
}

