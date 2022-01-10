package com.example.demo.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "personality")
public class Personality{

    @Id
    @SequenceGenerator(
        name = "personality_sequence",
        sequenceName = "personality_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "personality_sequence"
    )
    public Long id;
    public String description;

    public Personality() {
    }

    public Personality(Long id, String description) {
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

    public Personality id(Long id) {
        setId(id);
        return this;
    }

    public Personality description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Personality)) {
            return false;
        }
        Personality personality = (Personality) o;
        return Objects.equals(id, personality.id) && Objects.equals(description, personality.description);
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
