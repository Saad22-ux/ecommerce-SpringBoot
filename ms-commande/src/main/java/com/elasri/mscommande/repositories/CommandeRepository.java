package com.elasri.mscommande.repositories;

import com.elasri.mscommande.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
