package com.example.demo.resource;

import com.example.demo.dto.SessionDto;
import com.example.demo.entity.Person;
import com.example.demo.entity.Session;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.SessionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/sessions")
@AllArgsConstructor
public class SessionController {

    private final SessionRepository sessionRepository;
    private final PersonRepository personRepository;

    @GetMapping
    public List<Session> allSessions() {
        return sessionRepository.findAll();
    }

    @PostMapping(path = "/add")
    @Transactional
    public Session addSession(@RequestBody SessionDto dto) {
        System.out.println("dto = " + dto);

        Person person = personRepository
                .findById(dto.getPersonId())
                .orElseThrow(() -> new RuntimeException("No person could be found for id " + dto.getPersonId()));
        System.out.println("person = " + person);

        var s = new Session();
        s.setDate(dto.getDate());
        s.setTime(dto.getTime());
        s.setPerson(person);
        s.setDescription(dto.getDescription());
        return sessionRepository.save(s);
    }

    @PostMapping(path = "add-all")
    public Collection<Session> addSessions(@RequestBody Set<SessionDto> sessions) {
        Map<Long, Person> personMap = new HashMap<>();
        Set<Session> sessions2 = sessions.stream().map(dto -> {
            var s = new Session();
            s.setDate(dto.getDate());
            s.setTime(dto.getTime());
            s.setPerson(personMap.computeIfAbsent(dto.getPersonId(),
                    aLong -> personRepository.findById(aLong)
                            .orElseThrow(() -> new RuntimeException("No person could be found for id " + aLong))));

            return s;
        }).collect(Collectors.toSet());
        return sessionRepository.saveAll(sessions2);
    }

}
