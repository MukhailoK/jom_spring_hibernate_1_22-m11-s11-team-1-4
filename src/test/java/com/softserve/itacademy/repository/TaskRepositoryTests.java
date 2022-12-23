package com.softserve.itacademy.repository;

import com.softserve.itacademy.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TaskRepositoryTests {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    StateRepository stateRepository;

    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Test
    public void createTask() {
        Task task = new Task();
        State state = new State();
        ToDo toDo = new ToDo();
        User user = new User();
        Role role = new Role();

        role.setName("RoleName");
        role = roleRepository.save(role);

        user.setFirstName("UserFirstName");
        user.setLastName("UserLastName");
        user.setEmail("user@email.com");
        user.setPassword("password");
        user.setRole(role);
        user = userRepository.save(user);
        state.setName("StateName");

        toDo.setTitle("TodoTitle");
        toDo.setOwner(user);
        toDo = toDoRepository.save(toDo);

        task.setName("TaskName");
        task.setPriority(Priority.LOW);
        task.setState(state);
        task.setToDo(toDo);

        task = taskRepository.save(task);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Task>> violations = validator.validate(task);
        assertEquals(0, violations.size());

    }
}
