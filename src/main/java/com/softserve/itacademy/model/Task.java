package com.softserve.itacademy.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name) && priority == task.priority && Objects.equals(state, task.state) && Objects.equals(toDo, task.toDo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, priority, state, toDo);
    }
}
