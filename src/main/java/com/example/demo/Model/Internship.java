package com.example.demo.Model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Internship {

    public Internship() {
    }

    public Internship(Long id, String name, Date start_date, Date end_date, List<Long> targeted_faculties, List<Long> competences_acquired) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.targeted_faculties = targeted_faculties;
        this.competences_acquired = competences_acquired;
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

    public List<Long> getTargeted_faculties() {
        return this.targeted_faculties;
    }

    public void setTargeted_faculties(List<Long> targeted_faculties) {
        this.targeted_faculties = targeted_faculties;
    }

    public List<Long> getCompetences_acquired() {
        return this.competences_acquired;
    }

    public void setCompetences_acquired(List<Long> competences_acquired) {
        this.competences_acquired = competences_acquired;
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

    public Internship targeted_faculties(List<Long> targeted_faculties) {
        setTargeted_faculties(targeted_faculties);
        return this;
    }

    public Internship competences_acquired(List<Long> competences_acquired) {
        setCompetences_acquired(competences_acquired);
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
        return Objects.equals(id, internship.id) && Objects.equals(name, internship.name) && Objects.equals(start_date, internship.start_date) && Objects.equals(end_date, internship.end_date) && Objects.equals(targeted_faculties, internship.targeted_faculties) && Objects.equals(competences_acquired, internship.competences_acquired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, start_date, end_date, targeted_faculties, competences_acquired);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", start_date='" + getStart_date() + "'" +
            ", end_date='" + getEnd_date() + "'" +
            ", targeted_faculties='" + getTargeted_faculties() + "'" +
            ", competences_acquired='" + getCompetences_acquired() + "'" +
            "}";
    }
    public Long id;
    public String name;
    public Date start_date;
    public Date end_date;
    public List<Long> targeted_faculties;
    public List<Long> competences_acquired;
    
}
