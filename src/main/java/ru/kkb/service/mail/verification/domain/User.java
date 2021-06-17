package ru.kkb.service.mail.verification.domain;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;
    private String email;
    private String activationCode;

}
