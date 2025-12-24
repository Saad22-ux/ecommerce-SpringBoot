package com.elasri.mscommande.web;


import com.elasri.mscommande.entities.Commande;
import com.elasri.mscommande.modele.Client;
import com.elasri.mscommande.modele.Produit;
import com.elasri.mscommande.repositories.CommandeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeController {
    CommandeRepository commandeRepository;
    ClientOpenFeign clientOpenFeign;
    ProduitOpenFeign produitOpenFeign;

    public CommandeController(CommandeRepository commandeRepository,  ClientOpenFeign clientOpenFeign, ProduitOpenFeign produitOpenFeign) {
        this.commandeRepository = commandeRepository;
        this.clientOpenFeign = clientOpenFeign;
        this.produitOpenFeign = produitOpenFeign;
    }


    @GetMapping("/commandes")
    public List<Commande> findAll() {
        List<Commande> commandes = commandeRepository.findAll();
        List<Client> clients = clientOpenFeign.getAllClients();
        List<Produit> produits = produitOpenFeign.getAllProduits();
        for(Commande commande : commandes){
            for(Client client : clients){
                if(commande.getIdClient() == client.getIdClient()){
                    commande.setClient(client);
                    break;
                }
            }
            for (Produit produit : produits){
                if(commande.getIdProduit() == produit.getIdProduit()){
                    commande.setProduit(produit);
                }
            }
        }
        return commandes;
    }

    @GetMapping("/commandes/{id}")
    public Commande findById(@PathVariable Long id) {
        Commande commande = commandeRepository.findById(id).get();
        Client client = clientOpenFeign.getClientById(commande.getIdClient());
        Produit produit = produitOpenFeign.getProduitById(commande.getIdCommande());

        commande.setClient(client);
        commande.setProduit(produit);
        return commande;
    }

    @PostMapping("/commandes")
    public Commande save(@RequestBody Commande commande) {
        return commandeRepository.save(commande);
    }

    @PutMapping("/commandes/{id}")
    public Commande update(@PathVariable Long id, @RequestBody Commande commande) {
        Commande cmd = commandeRepository.findById(id).get();
        BeanUtils.copyProperties(commande, cmd);
        commandeRepository.save(cmd);
        return cmd;
    }

    @DeleteMapping("/commandes/{id}")
    public void deleteById(@PathVariable Long id) {
        commandeRepository.deleteById(id);
    }
}
