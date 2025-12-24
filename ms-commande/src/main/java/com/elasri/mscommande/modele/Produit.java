package com.elasri.mscommande.modele;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Produit {
    private Long idProduit;
    private String name;
    private String description;
    private Double price;
}
