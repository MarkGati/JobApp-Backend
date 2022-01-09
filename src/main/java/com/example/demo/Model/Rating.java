package com.example.demo.Model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating{

    @Id
    @SequenceGenerator(
        name = "rating_sequence",
        sequenceName = "rating_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "rating_sequence"
    )
    public Long id;
    public String description;

    public Rating() {
    }

    public Rating(Long id, String description) {
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

    public Rating id(Long id) {
        setId(id);
        return this;
    }

    public Rating description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rating)) {
            return false;
        }
        Rating rating = (Rating) o;
        return id == rating.id && Objects.equals(description, rating.description);
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
