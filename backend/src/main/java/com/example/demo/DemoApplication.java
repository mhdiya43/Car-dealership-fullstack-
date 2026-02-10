package com.example.demo;

import com.example.demo.modele.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private VoitureRepo repository;

    @Autowired
    private ProprietaireRepo proprietaireRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
CommandLineRunner runner() {
    return args -> {

        Proprietaire p1 = new Proprietaire("Ali", "Hassan");
        Proprietaire p2 = new Proprietaire("Najat", "Bani");

        proprietaireRepo.save(p1);
        proprietaireRepo.save(p2);

        Voiture v1 = new Voiture();
        v1.setMarque("Toyota");
        v1.setModele("Corolla");
        v1.setCouleur("Grise");
        v1.setImmatricule("A-1-9090");
        v1.setAnnee(2018);
        v1.setPrix(95000);
        v1.setProprietaire(p1);
        repository.save(v1);

        Voiture v2 = new Voiture();
        v2.setMarque("Ford");
        v2.setModele("Fiesta");
        v2.setCouleur("Rouge");
        v2.setImmatricule("A-2-8090");
        v2.setAnnee(2015);
        v2.setPrix(90000);
        v2.setProprietaire(p1);
        repository.save(v2);

        Voiture v3 = new Voiture();
        v3.setMarque("Honda");
        v3.setModele("CRV");
        v3.setCouleur("Bleu");
        v3.setImmatricule("A-3-7090");
        v3.setAnnee(2016);
        v3.setPrix(140000);
        v3.setProprietaire(p2);
        repository.save(v3);
    };
}

}