package com.elasri.msclient;

import com.elasri.msclient.entities.Client;
import com.elasri.msclient.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsClientApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ClientRepository clientRepository) {
        return args -> {
            Client clt1 = Client.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("Johndoe@gmail.com")
                    .build();
            clientRepository.save(clt1);

            Client clt2 = Client.builder()
                    .firstName("Saad")
                    .lastName("Elasri")
                    .email("Saadelasri@gmail.com")
                    .build();
            clientRepository.save(clt2);

            Client clt3 = Client.builder()
                    .firstName("Saad")
                    .lastName("Elasri")
                    .email("Saadelasri@gmail.com")
                    .build();
            clientRepository.save(clt3);
        };
    }

}
