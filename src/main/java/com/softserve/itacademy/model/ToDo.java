package com.softserve.itacademy.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();
    @ManyToMany(mappedBy = "collaboratorsTodos")
    private List<User> collaborators;

}
