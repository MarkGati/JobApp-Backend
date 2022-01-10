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
    public String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "internships_domains",
        joinColumns = @JoinColumn(name = "internship_id"),
        inverseJoinColumns = @JoinColumn(name = "domain_id")
    )
    public Set<Domain> domains;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "organizations_users",
        joinColumns = @JoinColumn(name = "organization_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public Set<User> users;

    public Organization(Long id, String name, Set<Domain> domains, Set<User> users) {
        this.id = id;
        this.name = name;
        this.domains = domains;
        this.users = users;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Organization name(String name) {
        setName(name);
        return this;
    }

    public Organization users(Set<User> users) {
        setUsers(users);
        return this;
    }

    public Organization() {
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
