package nl.pr.assessment.persistence.mapper;
import nl.pr.assessment.persistence.entity.PersonEntity;
import nl.pr.assessment.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Youri de Vlam
 * Unit tests for the {@link PersonMapping} functionality
 */
class PersonMappingTest {

    private final PersonMapping mapper = new PersonMapping();

    @Test
    void testToModelAndToEntity() {
        // Arrange
        PersonEntity entity = new PersonEntity.Builder()
                .id(1L)
                .name("John Doe")
                .birthDate(LocalDate.of(1990, 1, 1))
                .parent1(null)
                .parent2(null)
                .partner(null)
                .children(Collections.emptySet())
                .build();

        // Act
        Person model = mapper.toModel(entity);

        // Assert
        assertNotNull(model);
        assertEquals(entity.getId(), model.getId());
        assertEquals(entity.getName(), model.getName());
        assertEquals(entity.getBirthDate(), model.getBirthDate());

        // Reverse mapping
        PersonEntity mappedEntity = mapper.toEntity(model);
        assertNotNull(mappedEntity);
        assertEquals(entity.getId(), mappedEntity.getId());
        assertEquals(entity.getName(), mappedEntity.getName());
        assertEquals(entity.getBirthDate(), mappedEntity.getBirthDate());
    }

    @Test
    void testNullInput() {
        assertNull(mapper.toModel(null));
        assertNull(mapper.toEntity(null));
    }
}