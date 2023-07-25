package com.example.demo.resource;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping(path = "/test")
    String test() {
        return "Test!!";
    }

    @GetMapping
    public List<Person> persons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person create(@RequestBody @Valid Person person) {
        System.out.println("person = " + person);
        Person save = personRepository.save(person);
        System.out.println("save = " + save);
        return save;
    }

    @PostMapping
    public Person update(@RequestBody @Valid Person person) {
        System.out.println("person = " + person);
        Person save = personRepository.save(person);
        System.out.println("update = " + save);
        return save;
    }

    @GetMapping(path = "/{personId}")
    @Transactional
    public Person personById(@PathVariable long personId) {
        var person = personRepository
                .findById(personId)
                .orElseThrow(() -> new RuntimeException("No person could be found for id " + personId));
        System.out.println("person = " + person);
        return person;
    }

}
