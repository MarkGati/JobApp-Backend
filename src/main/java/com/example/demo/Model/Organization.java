package com.example.demo.Model;

import java.util.Objects;

public class Organization {
    public Long id;
    public Long domain_id;

    public Organization() {
    }

    public Organization(Long id, Long domain_id) {
        this.id = id;
        this.domain_id = domain_id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDomain_id() {
        return this.domain_id;
    }

    public void setDomain_id(Long domain_id) {
        this.domain_id = domain_id;
    }

    public Organization id(Long id) {
        setId(id);
        return this;
    }

    public Organization domain_id(Long domain_id) {
        setDomain_id(domain_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization organization = (Organization) o;
        return Objects.equals(id, organization.id) && Objects.equals(domain_id, organization.domain_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domain_id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", domain_id='" + getDomain_id() + "'" +
            "}";
    }
    
}
