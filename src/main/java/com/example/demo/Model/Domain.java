package com.example.demo.Model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "domain")
public class Domain{

    @Id
    @SequenceGenerator(
        name = "domain_sequence",
        sequenceName = "domain_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "domain_sequence"
    )
    public Long id;
    public String description;

    public Domain() {
    }

    public Domain(Long id, String description) {
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

    public Domain id(Long id) {
        setId(id);
        return this;
    }

    public Domain description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Domain)) {
            return false;
        }
        Domain domain = (Domain) o;
        return Objects.equals(id, domain.id) && Objects.equals(description, domain.description);
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
