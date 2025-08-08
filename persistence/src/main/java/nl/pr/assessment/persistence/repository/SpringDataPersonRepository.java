package nl.pr.assessment.persistence.repository;

import nl.pr.assessment.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Youri de Vlam
 *
 * Repository interface for managing PersonEntity objects.
 */
public interface SpringDataPersonRepository extends JpaRepository<PersonEntity, Long> {
}
