package com.softserve.itacademy.repository;

import com.softserve.itacademy.model.Role;
import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.OffsetDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ToDoRepositoryTests {
    @Autowired
    ToDoRepository toDoRepository;
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();



    @Test
    public void createToDo() {
        ToDo todo = new ToDo();
        User owner = new User();

        OffsetDateTime time = OffsetDateTime.now();
        todo.setId(1L);
        todo.setCreatedAt(time);
        todo.setTitle("myToDo");
        todo.setOwner(owner);
        toDoRepository.save(todo);

        assertEquals(todo.getId(), 1L);
        assertEquals(todo.getCreatedAt(), time);
        assertEquals(todo.getTitle(), "myToDo");
        assertEquals(todo.getOwner(), owner);
    }

    @Test
    public void createInvalidToDo(){
        ToDo todo = new ToDo();
        User owner = new User();



        OffsetDateTime time = OffsetDateTime.now();
        todo.setId(1L);
        todo.setCreatedAt(time);
        todo.setTitle("");
        todo.setOwner(owner);
        toDoRepository.save(todo);

        Set<ConstraintViolation<ToDo>> violations = validator.validate(todo);
        assertEquals(violations.size(), 1);

    }

}

