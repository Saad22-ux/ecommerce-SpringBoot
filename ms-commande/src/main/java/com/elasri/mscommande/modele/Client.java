package com.elasri.mscommande.modele;

import lombok.*;

@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
public class Client {
    private Long idClient;
    private String firstName;
    private String lastName;
    private String email;
}
