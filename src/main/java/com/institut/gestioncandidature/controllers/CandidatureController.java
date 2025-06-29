package com.institut.gestioncandidature.controllers;


import com.institut.gestioncandidature.dto.CandidatureRequest;
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
    public ResponseEntity<Candidature> addCandidature(@RequestBody CandidatureRequest request) {
        return ResponseEntity.ok(candidatureService.save(request));
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


    @PutMapping("/{id}")
    public ResponseEntity<Candidature> updateCandidature(@PathVariable Long id, @RequestBody CandidatureRequest request) {
        Candidature updatedCandidature = candidatureService.update(id, request);
        return ResponseEntity.ok(updatedCandidature);
    }


}
