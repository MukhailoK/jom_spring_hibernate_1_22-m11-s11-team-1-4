package com.softserve.itacademy.repository;

import com.softserve.itacademy.model.Role;
import com.softserve.itacademy.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void createRole() {

        User user = new User();
        Role role = new Role();

        role.setName("NEW");
        role = roleRepository.save(role);
        user.setRole(role);
        user.setLastName("Last-Name");
        user.setFirstName("First-Name");
        user.setEmail("user@gmai.com");
        user.setPassword("213werwer_!Q");

        user = userRepository.save(user);
        assertEquals(4, user.getId());
        assertEquals("Last-Name", user.getLastName());
        assertEquals("First-Name", user.getFirstName());
        assertEquals("user@gmai.com", user.getEmail());
        assertEquals("213werwer_!Q",user.getPassword());
        assertEquals(role, user.getRole());
    }
}
