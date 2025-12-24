package com.elasri.mscommande.web;

import com.elasri.mscommande.modele.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("MS-CLIENT")
public interface ClientOpenFeign {
    @GetMapping("/clients")
    public List<Client> getAllClients();
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable Long id);
}
