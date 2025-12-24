package com.elasri.msproduit;

import com.elasri.msproduit.entities.Produit;
import com.elasri.msproduit.repositories.ProduitRepository;
import com.elasri.msproduit.web.ProduitController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProduitApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProduitRepository produitRepository) {
        return args -> {
            Produit p1 = Produit
                    .builder()
                    .name("Lenovo")
                    .description("Pc portable Intel i5 10 eme generation")
                    .price(3200.00)
                    .build();
            produitRepository.save(p1);

            Produit p2 = Produit
                    .builder()
                    .name("HP")
                    .description("Pc portable Intel i7 11 eme generation")
                    .price(5000.25)
                    .build();
            produitRepository.save(p2);

            Produit p3 = Produit
                    .builder()
                    .name("Samsung s24")
                    .description("Telephone portable avec 256 Go stockage et 16 Go RAM")
                    .price(7000.00)
                    .build();
            produitRepository.save(p3);
        };
    }
}
