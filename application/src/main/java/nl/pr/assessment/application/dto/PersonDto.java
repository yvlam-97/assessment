package nl.pr.assessment.application.dto;

import java.time.LocalDate;
import java.util.List;
import nl.pr.assessment.model.Person;

public record PersonDto(Long id, String name, LocalDate birthDate, Long parent1Id, Long parent2Id, Long partnerId, List<Long> childrenIds) {
    public PersonDto(Person person) {
        this(person.getId(), person.getName(), person.getBirthDate(),
             person.getParent1() != null ? person.getParent1().getId() : null,
             person.getParent2() != null ? person.getParent2().getId() : null,
             person.getPartner() != null ? person.getPartner().getId() : null,
                person.getChildren().stream()
                     .map(Person::getId)
                     .toList());
    }
}
