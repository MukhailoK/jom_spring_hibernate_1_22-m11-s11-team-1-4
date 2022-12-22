package com.softserve.itacademy.model;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Pattern(regexp = "^[a-zA-Z\\d\\-\\s_]{3,30}$"
            , message = "The email must contain from 3 to 30 latin letters, numbers, dash, space and underscore")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Pattern(regexp = "^[a-zA-Z\\d\\-\\s_]{1,20}$"
            , message = "The firstName must contain from 1 to 20 latin letters, numbers, dash, space and underscore")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z\\d\\-\\s_]{1,20}$"
            , message = "The lastName must contain from 1 to 20 latin letters, numbers, dash, space and underscore")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Pattern(regexp = "^[a-zA-Z\\d\\-\\s_]{8,20}$"
            , message = "The password must contain from 8 to 20 latin letters, numbers, dash, space and underscore")
    @Column(name = "password", nullable = false)
    private String password;

    @Setter(AccessLevel.PRIVATE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @ManyToOne
    private Role role;
}
