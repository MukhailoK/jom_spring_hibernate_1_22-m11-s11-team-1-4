package com.softserve.itacademy.model;

import org.junit.jupiter.api.BeforeAll;
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
public class TaskTests {
    private static Role traineeRole;
    private static User owner;
    private static ToDo todo;
    private static State state;
    private static Task validTask;

    @BeforeAll
    static void init(){
        traineeRole = new Role();
        traineeRole.setName("TRAINEE");
        owner  = new User();
        owner.setEmail("valid@cv.edu.ua");
        owner.setFirstName("Valid-Name");
        owner.setLastName("Valid-Name");
        owner.setPassword("qwQW12!@");
        owner.setRole(traineeRole);

        todo = new ToDo();
        todo.setOwner(owner);
        todo.setId(1L);
        todo.setTitle("Valid title");

        state = new State();
        state.setId(1L);
        state.setName("Finished");

        validTask = new Task();
        validTask.setName("myTask");
        validTask.setId(1L);
        validTask.setPriority(Priority.LOW);
        validTask.setState(state);
    }

    @Test
    public void constraintViolationInvalidTaskName(){
        Task task = validTask;
        task.setName("A");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Task>> violations = validator.validate(task);
        assertEquals(1, violations.size());
    }


}
