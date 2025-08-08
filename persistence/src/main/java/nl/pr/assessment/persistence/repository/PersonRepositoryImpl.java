package nl.pr.assessment.persistence.repository;

import java.util.Optional;
import nl.pr.assessment.model.Person;
import nl.pr.assessment.repository.PersonRepository;
import nl.pr.assessment.persistence.entity.PersonEntity;
import nl.pr.assessment.persistence.mapper.PersonMapping;
import org.springframework.stereotype.Repository;

/**
 * @author Youri de Vlam
 *
 * Repository implementation for managing Person entities.
 */
@Repository
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
