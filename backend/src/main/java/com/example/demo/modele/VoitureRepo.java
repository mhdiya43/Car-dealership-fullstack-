package com.example.demo.modele;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VoitureRepo extends CrudRepository<Voiture, Long> {

    // /api/voitures/search/findByMarque?marque=Toyota
    List<Voiture> findByMarque(@Param("marque") String marque);

    // /api/voitures/search/findByCouleur?couleur=Rouge
    List<Voiture> findByCouleur(@Param("couleur") String couleur);

    // /api/voitures/search/findByAnnee?annee=2018
    List<Voiture> findByAnnee(@Param("annee") int annee);

    // /api/voitures/search/findByMarqueAndModele?marque=Toyota&modele=Corolla
    List<Voiture> findByMarqueAndModele(
        @Param("marque") String marque,
        @Param("modele") String modele
    );

    // /api/voitures/search/findByMarqueOrCouleur?marque=Toyota&couleur=Rouge
    List<Voiture> findByMarqueOrCouleur(
        @Param("marque") String marque,
        @Param("couleur") String couleur
    );

    // /api/voitures/search/findByMarqueOrderByAnneeAsc?marque=Toyota
    List<Voiture> findByMarqueOrderByAnneeAsc(@Param("marque") String marque);

    // JPQL exposé
    @Query("select v from Voiture v where v.marque = :marque")
    List<Voiture> chercherParMarque(@Param("marque") String marque);

    // LIKE %x
    @Query("select v from Voiture v where v.marque like %:suffix")
    List<Voiture> findByMarqueEndsWith(@Param("suffix") String suffix);
}
