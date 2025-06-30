package com.institut.gestioncandidature.controllers;


import com.institut.gestioncandidature.models.Filiere;
import com.institut.gestioncandidature.services.FiliereService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filieres")
@RequiredArgsConstructor
@CrossOrigin
public class FiliereController {

    private final FiliereService filiereService;

    @PostMapping
    public ResponseEntity<Filiere> create(@RequestBody Filiere filiere) {
        return ResponseEntity.ok(filiereService.create(filiere));
    }

    @GetMapping
    public ResponseEntity<List<Filiere>> getAll() {
        return ResponseEntity.ok(filiereService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filiere> getById(@PathVariable Long id) {
        return ResponseEntity.ok(filiereService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filiere> update(@PathVariable Long id, @RequestBody Filiere filiere) {
        return ResponseEntity.ok(filiereService.update(id, filiere));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filiereService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
