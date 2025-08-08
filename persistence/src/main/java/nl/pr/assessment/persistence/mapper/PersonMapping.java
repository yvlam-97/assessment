package nl.pr.assessment.persistence.mapper;

import java.util.stream.Collectors;
import nl.pr.asessment.model.Person;
import nl.pr.assessment.persistence.entity.PersonEntity;
import org.springframework.stereotype.Component;

/**
 * @author Youri de Vlam
 *
 * Mapper class for converting between Person model and PersonEntity.
 */
@Component
public class PersonMapping {

    /**
     * Converts a PersonEntity to a Person model.
     *
     * @param personEntity the {@link PersonEntity} to convert
     * @return the converted {@link Person} or null if the input is null
     */
    public Person toModel(PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        }
        Person person = new Person(personEntity.getId());
        person.setName(personEntity.getName());
        person.setBirthDate(personEntity.getBirthDate());
        person.setParent1(toModel(personEntity.getParent1()));
        person.setParent2(toModel(personEntity.getParent2()));
        person.setPartner(toModel(personEntity.getPartner()));
        person.getChildren().addAll(
                personEntity.getChildren().stream()
                        .map(this::toModel)
                        .collect(Collectors.toSet())
        );
        return person;
    }

    /**
     * Converts a PersonEntity to a Person model.
     *
     * @param person the {@link Person} to convert
     * @return the converted {@link PersonEntity} or null if the input is null
     */
    public PersonEntity toEntity(Person person) {
        if (person == null) {
            return null;
        }
        return new PersonEntity.Builder()
                .id(person.getId())
                .name(person.getName())
                .birthDate(person.getBirthDate())
                .parent1(toEntity(person.getParent1()))
                .parent2(toEntity(person.getParent2()))
                .partner(toEntity(person.getPartner()))
                .children(person.getChildren().stream()
                        .map(this::toEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
