package com.elasri.mscommande.entities;


import com.elasri.mscommande.modele.Client;
import com.elasri.mscommande.modele.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Builder
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private Long idProduit;
    @Transient
    private Produit produit;

    private int quantite;
    private Long idClient;
    @Transient
    private Client client;
}
