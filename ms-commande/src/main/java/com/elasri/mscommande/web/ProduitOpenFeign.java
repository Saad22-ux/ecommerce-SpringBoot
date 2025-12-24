package com.elasri.mscommande.web;

import com.elasri.mscommande.modele.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("MS-PRODUIT")
public interface ProduitOpenFeign {
    @GetMapping("/produits")
    public List<Produit> getAllProduits();
    @GetMapping("/produits/{id}")
    public Produit getProduitById(@PathVariable Long id);
}
