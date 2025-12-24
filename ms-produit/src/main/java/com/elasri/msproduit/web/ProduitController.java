package com.elasri.msproduit.web;

import com.elasri.msproduit.entities.Produit;
import com.elasri.msproduit.repositories.ProduitRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {
    ProduitRepository produitRepository;

    public  ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping("/produits")
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @GetMapping("/produits/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitRepository.findById(id).get();
    }

    @PostMapping("/produits")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    @PutMapping("/produits/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        Produit p = produitRepository.findById(id).get();
        BeanUtils.copyProperties(produit, p);
        produitRepository.save(p);
        return p;
    }

    @DeleteMapping("/produits/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
    }
}
