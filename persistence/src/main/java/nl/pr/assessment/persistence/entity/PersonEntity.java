package nl.pr.assessment.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author Youri de Vlam
 * Entity class representing a person in the database.
 * This class maps to the "people" table and includes relationships
 * to other person entities for parents, partner, and children.
 */
@Entity
@Table(name = "people")
public class PersonEntity {

    @Id
    private Long id;
    private String name;
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "parent1_id")
    private PersonEntity parent1;

    @ManyToOne
    @JoinColumn(name = "parent2_id")
    private PersonEntity parent2;

    @OneToOne
    @JoinColumn(name = "partner_id")
    private PersonEntity partner;

    @OneToMany
    @JoinTable(
        name = "person_children",
        joinColumns = @JoinColumn(name = "parent_id"),
        inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private Set<PersonEntity> children;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public PersonEntity getParent1() {
        return parent1;
    }

    public PersonEntity getParent2() {
        return parent2;
    }

    public PersonEntity getPartner() {
        return partner;
    }

    public Set<PersonEntity> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setParent1(PersonEntity parent1) {
        this.parent1 = parent1;
    }

    public void setParent2(PersonEntity parent2) {
        this.parent2 = parent2;
    }

    public void setPartner(PersonEntity partner) {
        this.partner = partner;
    }

    public void setChildren(Set<PersonEntity> children) {
        this.children = children;
    }

    /**
     * Builder class for constructing PersonEntity instances.
     */
    public static class Builder {
        private final PersonEntity entity;

        public Builder() {
            entity = new PersonEntity();
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder name(String name) {
            entity.setName(name);
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            entity.setBirthDate(birthDate);
            return this;
        }

        public Builder parent1(PersonEntity parent1) {
            entity.setParent1(parent1);
            return this;
        }

        public Builder parent2(PersonEntity parent2) {
            entity.setParent2(parent2);
            return this;
        }

        public Builder partner(PersonEntity partner) {
            entity.setPartner(partner);
            return this;
        }

        public Builder children(Set<PersonEntity> children) {
            entity.setChildren(children);
            return this;
        }

        public PersonEntity build() {
            return entity;
        }
    }

}
