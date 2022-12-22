package com.softserve.itacademy.model;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Email
    @NotBlank
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "first_name", nullable = false)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\d\\-\\s_]{1,20}$", message = "The stateName must contain from 1 to 20 latin letters, numbers, dash, space and underscore")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\d\\-\\s_]{1,20}$", message = "The stateName must contain from 1 to 20 latin letters, numbers, dash, space and underscore")
    private String lastName;
    @Column(name = "password", nullable = false)
    @NotNull
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "todo_collaborator",
            joinColumns = { @JoinColumn(name = "collaborator_id") },
            inverseJoinColumns = { @JoinColumn(name = "todo_id") }
    )
    private List<ToDo> collaboratorsTodos;
}
