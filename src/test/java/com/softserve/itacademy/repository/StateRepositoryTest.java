package com.softserve.itacademy.repository;

import com.softserve.itacademy.model.State;
import com.softserve.itacademy.model.User;
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
public class StateRepositoryTest {
    @Autowired
    StateRepository stateRepository;

    @Test
    public void addStateName() {
        State state = new State();
        state.setName("StateName");
        state.setName("StateName2");
        state.setName("StateName3");

        state = stateRepository.save(state);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<State>> violations = validator.validate(state);

        assertEquals(0, violations.size());
    }
}