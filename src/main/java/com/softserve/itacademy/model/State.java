package com.softserve.itacademy.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Data
@Table(name = "states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Pattern(regexp = "^[a-zA-Z\\d\\-\\s_]{1,20}$", message = "The stateName must contain from 1 to 20 latin letters, numbers, dash, space and underscore")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
