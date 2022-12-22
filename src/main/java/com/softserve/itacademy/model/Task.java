package com.softserve.itacademy.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Setter(AccessLevel.PRIVATE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 3, max = 200, message = "The taskName should be with minimum 3 and maximum 200 any symbols")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "The priority cannot be empty")
    @Column(name = "priority", nullable = false)
    private Priority priority;

    @OneToOne
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private ToDo toDo;

}
