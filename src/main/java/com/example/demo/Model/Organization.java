package com.example.demo.Model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "organization")
public class Organization{
    @Id
    @SequenceGenerator(
        name = "organization_sequence",
        sequenceName = "organization_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "organization_sequence"
    )
    public Long id;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "internships_domains",
        joinColumns = @JoinColumn(name = "internship_id"),
        inverseJoinColumns = @JoinColumn(name = "domain_id")
    )
    public Set<Domain> domains;

    public Organization() {
    }

    public Organization(Long id, Set<Domain> domains) {
        this.id = id;
        this.domains = domains;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Domain> getDomains() {
        return this.domains;
    }

    public void setDomains(Set<Domain> domains) {
        this.domains = domains;
    }

    public Organization id(Long id) {
        setId(id);
        return this;
    }

    public Organization domains(Set<Domain> domains) {
        setDomains(domains);
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
        return Objects.equals(id, organization.id) && Objects.equals(domains, organization.domains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domains);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", domains='" + getDomains() + "'" +
            "}";
    }
    
}
