package com.example.demo.Model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "competence")
public class Competence{

    @Id
    @SequenceGenerator(
        name = "competence_sequence",
        sequenceName = "competence_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "competence_sequence"
    )
    public Long id;
    public String description;

    public Competence() {
    }

    public Competence(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Competence id(Long id) {
        setId(id);
        return this;
    }

    public Competence description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Competence)) {
            return false;
        }
        Competence competence = (Competence) o;
        return Objects.equals(id, competence.id) && Objects.equals(description, competence.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
    
}
