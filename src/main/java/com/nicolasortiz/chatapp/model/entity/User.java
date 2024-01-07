package com.nicolasortiz.chatapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;


@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank
    private String name;

    @NotBlank @NotNull @Size(min = 3, max = 20)
    @Column(unique = true)
    @UniqueElements
    private String username;

    // El proyecto no implementa seguridad. Por eso están deshabilitadas las validaciones
//    @Email
    private String email;

//    @NotBlank @NotNull
    private String password;


}
