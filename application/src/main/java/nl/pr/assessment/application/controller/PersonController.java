package nl.pr.assessment.application.controller;

import java.util.HashSet;
import java.util.Set;
import nl.pr.assessment.application.dto.PersonDto;
import nl.pr.assessment.model.Person;
import nl.pr.assessment.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto dto) {
        if (dto.id() == null) {
            return ResponseEntity.badRequest().build();
        }
        // Main person
        Person person = personRepository.findById(dto.id()).orElse(new Person(dto.id()));
        person.setName(dto.name());
        person.setBirthDate(dto.birthDate());

        // Parents
        if(dto.parent1Id() != null) {
            person.setParent1(new Person(dto.parent1Id()));
        }
        if(dto.parent2Id() != null) {
            person.setParent2(new Person(dto.parent2Id()));
        }

        // Partner
        if(dto.partnerId() != null) {
            person.setPartner(new Person(dto.partnerId()));
        }

        // Children
        Set<Person> children = new HashSet<>();
        if (dto.childrenIds() != null) {
            for (Long childId : dto.childrenIds()) {
                if (childId != null) {
                    children.add(new Person(childId));
                }
            }
        }
        person.addChildren(children);

        personRepository.save(person);

        // Matching rule: if person exists and has name, then match
        boolean matches = personRepository.findById(dto.id())
                .map(p -> p.getName() != null && !p.getName().isBlank())
                .orElse(false);

        if (matches) {
            return ResponseEntity.ok(new PersonDto(person));
        }
        else {
            return ResponseEntity.status(444).build();
        }
    }
}
