package com.softserve.itacademy.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "tasks")
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 3, max = 200, message = "The taskName should be with minimum 3 and maximum 200 any symbols")
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "priority")
    @Enumerated(value = EnumType.STRING)
    private Priority priority;

    @OneToOne
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private ToDo toDo;

}
