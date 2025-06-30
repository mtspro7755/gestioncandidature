package com.institut.gestioncandidature.controllers;


import com.institut.gestioncandidature.models.Candidature;
import com.institut.gestioncandidature.services.CandidatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidatures")
@RequiredArgsConstructor
@CrossOrigin
public class CandidatureController {
    private final CandidatureService candidatureService;

    @PostMapping
    public ResponseEntity<Candidature> addCandidature(@RequestBody Candidature candidature) {
        return ResponseEntity.ok(candidatureService.save(candidature));
    }
    @GetMapping
    public ResponseEntity<List<Candidature>> getAll() {
        return ResponseEntity.ok(candidatureService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidature(@PathVariable Long id) {
        candidatureService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Candidature>> getCandidatureById(@PathVariable Long id) {
        return ResponseEntity.ok(candidatureService.findById(id));
    }





}
