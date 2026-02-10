package com.example.demo.web;

import com.example.demo.modele.Proprietaire;
import com.example.demo.modele.ProprietaireRepo;
import com.example.demo.modele.Voiture;
import com.example.demo.modele.VoitureRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/voitures")
public class VoitureController {

    @Autowired
    private VoitureRepo voitureRepo;

    
    
 @GetMapping
    public List<Voiture> getAllVoitures() {
        return (List<Voiture>) voitureRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Voiture> getVoitureById(@PathVariable Long id) {
        return voitureRepo.findById(id);
    }

    
     @PostMapping
    public Voiture createVoiture(@RequestBody Voiture voiture) {
        return voitureRepo.save(voiture);
    }

   
    @PutMapping("/{id}")
    public Voiture updateVoiture(
            @PathVariable Long id,
            @RequestBody Voiture voiture) {

        voiture.setId(id); 
        return voitureRepo.save(voiture);
    }

   
    @PatchMapping("/{id}")
    public Voiture patchVoiture(
            @PathVariable Long id,
            @RequestBody Voiture voiturePartielle) {

        Voiture voiture = voitureRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Voiture non trouvée"));

        if (voiturePartielle.getCouleur() != null)
            voiture.setCouleur(voiturePartielle.getCouleur());

        if (voiturePartielle.getPrix() != 0)
            voiture.setPrix(voiturePartielle.getPrix());

        return voitureRepo.save(voiture);
    }

   
    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        voitureRepo.deleteById(id);
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> headVoiture(@PathVariable Long id) {
        boolean exists = voitureRepo.existsById(id);
        return exists ? ResponseEntity.ok().build()
                      : ResponseEntity.notFound().build();
    }

    
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsVoiture() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "GET,POST,PUT,PATCH,DELETE,HEAD,OPTIONS");
        return ResponseEntity.ok().headers(headers).build();
    }
}
