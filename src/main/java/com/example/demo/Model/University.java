package com.example.demo.Model;

import java.util.Objects;

public class University {
    public Long id;
    public String name;

    public University() {
    }

    public University(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public University id(Long id) {
        setId(id);
        return this;
    }

    public University name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof University)) {
            return false;
        }
        University university = (University) o;
        return id == university.id && Objects.equals(name, university.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
    
}
