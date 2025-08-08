package nl.pr.asessment.repository;

import java.util.Optional;
import nl.pr.asessment.model.Person;

/**
 * @author Youri de Vlam
 *
 * This interface defines the contract for a repository for managing Person entities.
 */
public interface PersonRepository {

    /**
     * Saves a person to the repository.
     *
     * @param person The person to save.
     */
    Person save(Person person);

    /**
     * Finds a person by their ID.
     *
     * @param id The ID of the person to find.
     * @return The found person, wrapped in an Optional, or empty if not found.
     */
    Optional<Person> findById(long id);

    /**
     * Deletes a person from the repository.
     *
     * @param person The person to delete.
     */
    void delete(Person person);
}
