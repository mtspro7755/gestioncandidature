package com.institut.gestioncandidature.controllers;


import com.institut.gestioncandidature.models.Candidat;
import com.institut.gestioncandidature.services.CandidatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidats")
@CrossOrigin
@RequiredArgsConstructor
public class CandidatController {
    private final CandidatService candidatService;

    @GetMapping
    public ResponseEntity<List<Candidat>> getAllCandidats() {
        return ResponseEntity.ok(candidatService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Candidat>> getCandidatById(@PathVariable Long id) {
        return ResponseEntity.ok(candidatService.getById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCandidat(@PathVariable Long id) {
        candidatService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<Object> addCandidat(@RequestBody Candidat candidat) {
        Candidat savecandidat =candidatService.save(candidat);
        return ResponseEntity.ok(savecandidat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCandidat(@PathVariable Long id, @RequestBody Candidat candidat) {
        return ResponseEntity.ok(candidatService.update(id, candidat));
    }
}
