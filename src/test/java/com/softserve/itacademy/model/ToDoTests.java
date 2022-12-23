package com.softserve.itacademy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.OffsetDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ToDoTests {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();


    @Test
    public void constraintViolationOnEmptyTitle(){
        ToDo todo = new ToDo();
        User owner = new User();

        OffsetDateTime time = OffsetDateTime.now();
        todo.setId(1L);
        todo.setCreatedAt(time);
        todo.setTitle("");
        todo.setOwner(owner);

        Set<ConstraintViolation<ToDo>> violations = validator.validate(todo);
        assertEquals(violations.size(), 1);

    }


}
