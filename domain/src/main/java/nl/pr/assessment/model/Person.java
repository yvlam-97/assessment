package nl.pr.assessment.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Youri de Vlam
 *
 * This model represents a person.
 */
public class Person {
    private final long id;
    private String name;
    private LocalDate birthDate;
    private Person parent1;
    private Person parent2;
    private Person partner;
    private final Set<Person> children = new HashSet<>();

    /**
     * Constructor for creating a new Person instance.
     *
     * @param id The unique identifier for the person.
     */
    public Person(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Person getParent1() {
        return parent1;
    }

    public Person getParent2() {
        return parent2;
    }

    public Person getPartner() {
        return partner;
    }

    public Set<Person> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setParent1(Person parent1) {
        this.parent1 = parent1;
    }

    public void setParent2(Person parent2) {
        this.parent2 = parent2;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public void addChildren(Set<Person> children) {
        this.children.addAll(children);
    }
}
