package com.elasri.mscommande;

import com.elasri.mscommande.entities.Commande;
import com.elasri.mscommande.repositories.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MsCommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCommandeApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CommandeRepository commandeRepository) {
        return args -> {
            Commande commande1 = Commande
                    .builder()
                    .idClient(1L)
                    .idProduit(1L)
                    .quantite(5)
                    .build();
            commandeRepository.save(commande1);

            Commande commande2 = Commande
                    .builder()
                    .idClient(2L)
                    .idProduit(2L)
                    .quantite(10)
                    .build();
            commandeRepository.save(commande2);
        };
    }
}
