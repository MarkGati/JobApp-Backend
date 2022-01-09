package com.example.demo.Model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "internship")
public class Internship{

    public Internship() {
    }

    public Internship(Long id, String name, Date start_date, Date end_date, Long targeted_faculties_id, Long competences_acquired_id) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.targeted_faculties_id = targeted_faculties_id;
        this.competences_acquired_id = competences_acquired_id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return this.start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Long getTargeted_faculties_id() {
        return this.targeted_faculties_id;
    }

    public void setTargeted_faculties_id(Long targeted_faculties_id) {
        this.targeted_faculties_id = targeted_faculties_id;
    }

    public Long getCompetences_acquired_id() {
        return this.competences_acquired_id;
    }

    public void setCompetences_acquired_id(Long competences_acquired_id) {
        this.competences_acquired_id = competences_acquired_id;
    }

    public Internship id(Long id) {
        setId(id);
        return this;
    }

    public Internship name(String name) {
        setName(name);
        return this;
    }

    public Internship start_date(Date start_date) {
        setStart_date(start_date);
        return this;
    }

    public Internship end_date(Date end_date) {
        setEnd_date(end_date);
        return this;
    }

    public Internship targeted_faculties_id(Long targeted_faculties_id) {
        setTargeted_faculties_id(targeted_faculties_id);
        return this;
    }

    public Internship competences_acquired_id(Long competences_acquired_id) {
        setCompetences_acquired_id(competences_acquired_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Internship)) {
            return false;
        }
        Internship internship = (Internship) o;
        return Objects.equals(id, internship.id) && Objects.equals(name, internship.name) && Objects.equals(start_date, internship.start_date) && Objects.equals(end_date, internship.end_date) && Objects.equals(targeted_faculties_id, internship.targeted_faculties_id) && Objects.equals(competences_acquired_id, internship.competences_acquired_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, start_date, end_date, targeted_faculties_id, competences_acquired_id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", start_date='" + getStart_date() + "'" +
            ", end_date='" + getEnd_date() + "'" +
            ", targeted_faculties_id='" + getTargeted_faculties_id() + "'" +
            ", competences_acquired_id='" + getCompetences_acquired_id() + "'" +
            "}";
    }

    @Id
    @SequenceGenerator(
        name = "internship_sequence",
        sequenceName = "internship_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "internship_sequence"
    )
    public Long id;
    public String name;
    public Date start_date;
    public Date end_date;
    public Long targeted_faculties_id;
    public Long competences_acquired_id;
    
}
