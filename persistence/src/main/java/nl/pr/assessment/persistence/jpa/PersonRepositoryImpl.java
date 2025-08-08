package nl.pr.assessment.persistence.jpa;

import java.util.Optional;
import nl.pr.asessment.model.Person;
import nl.pr.asessment.repository.PersonRepository;
import nl.pr.assessment.persistence.entity.PersonEntity;
import nl.pr.assessment.persistence.mapper.PersonMapping;

/**
 * @author Youri de Vlam
 *
 * Repository implementation for managing Person entities.
 */
public class PersonRepositoryImpl implements PersonRepository {

    private final SpringDataPersonRepository jpaRepository;
    private final PersonMapping personMapping;

    /**
     * Constructor for PersonRepositoryImpl requires dependency injection of the JPA repository and the mapping component.
     *
     * @param jpaRepository the JPA repository for {@link PersonEntity}
     * @param personMapping the mapping component for converting between {@link Person} and {@link PersonEntity}
     */
    public PersonRepositoryImpl(SpringDataPersonRepository jpaRepository, PersonMapping personMapping) {
        this.jpaRepository = jpaRepository;
        this.personMapping = personMapping;
    }

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = personMapping.toEntity(person);
        return personMapping.toModel(jpaRepository.save(personEntity));
    }

    @Override
    public Optional<Person> findById(long id) {
        return jpaRepository.findById(id).map(personMapping::toModel);
    }

    @Override
    public void delete(Person person) {
        PersonEntity personEntity = personMapping.toEntity(person);
        jpaRepository.delete(personEntity);
    }
}
