package com.example.demo.Model;

import java.util.Objects;

public class Faculty {

    public Faculty() {
    }

    public Faculty(Long id, String name, Long university_id, Long domain_id) {
        this.id = id;
        this.name = name;
        this.university_id = university_id;
        this.domain_id = domain_id;
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

    public Long getUniversity_id() {
        return this.university_id;
    }

    public void setUniversity_id(Long university_id) {
        this.university_id = university_id;
    }

    public Long getDomain_id() {
        return this.domain_id;
    }

    public void setDomain_id(Long domain_id) {
        this.domain_id = domain_id;
    }

    public Faculty id(Long id) {
        setId(id);
        return this;
    }

    public Faculty name(String name) {
        setName(name);
        return this;
    }

    public Faculty university_id(Long university_id) {
        setUniversity_id(university_id);
        return this;
    }

    public Faculty domain_id(Long domain_id) {
        setDomain_id(domain_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Faculty)) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) && Objects.equals(name, faculty.name) && Objects.equals(university_id, faculty.university_id) && Objects.equals(domain_id, faculty.domain_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, university_id, domain_id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", university_id='" + getUniversity_id() + "'" +
            ", domain_id='" + getDomain_id() + "'" +
            "}";
    }
    public Long id;
    public String name;
    public Long university_id;
    public Long domain_id;

    
}
