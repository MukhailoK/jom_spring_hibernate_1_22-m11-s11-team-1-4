package com.softserve.itacademy.model;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
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
    @Pattern(regexp = "^[A-Z][a-z]+?(?:-[A-Z][a-z]+?)+?$", message = "The firstName incorrect")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]+?(?:-[A-Z][a-z]+?)+?$", message = "The lastName incorrect")
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