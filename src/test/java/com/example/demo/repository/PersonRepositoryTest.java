package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void simpleTest() {
        Person person = repository.save(new Person());
        assertThat(person).isNotNull();
        System.out.println("person = " + person);

        Optional<Person> fromDb = repository.findById(person.getId());
        assertThat(person).isEqualTo(fromDb.get());
    }
}