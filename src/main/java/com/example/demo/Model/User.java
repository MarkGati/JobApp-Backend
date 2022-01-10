package com.example.demo.Model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
 

 
@Entity
@Table(name = "users")
public class User{

    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    )

    public Long id;
    public String user_name;
    public String email;
    public String first_name;
    public String last_name;
    public String password;
    public Integer role;
    public String phone; 

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    public Set<Organization> organizations;

    @ManyToMany
    @JoinTable(
        name = "users_personalities",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "personality_id")
    )
    public Set<Personality> personalities;

    public User() {
    }

    public User(Long id, String user_name, String email, String first_name, String last_name, String password, Integer role, String phone, Set<Organization> organizations) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.organizations = organizations;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return this.role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Organization> getOrganizations() {
        return this.organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    public User id(Long id) {
        setId(id);
        return this;
    }

    public User user_name(String user_name) {
        setUser_name(user_name);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User first_name(String first_name) {
        setFirst_name(first_name);
        return this;
    }

    public User last_name(String last_name) {
        setLast_name(last_name);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User role(Integer role) {
        setRole(role);
        return this;
    }

    public User phone(String phone) {
        setPhone(phone);
        return this;
    }

    public User organizations(Set<Organization> organizations) {
        setOrganizations(organizations);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(user_name, user.user_name) && Objects.equals(email, user.email) && Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(password, user.password) && Objects.equals(role, user.role) && Objects.equals(phone, user.phone) && Objects.equals(organizations, user.organizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_name, email, first_name, last_name, password, role, phone, organizations);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user_name='" + getUser_name() + "'" +
            ", email='" + getEmail() + "'" +
            ", first_name='" + getFirst_name() + "'" +
            ", last_name='" + getLast_name() + "'" +
            ", password='" + getPassword() + "'" +
            ", role='" + getRole() + "'" +
            ", phone='" + getPhone() + "'" +
            ", organizations='" + getOrganizations() + "'" +
            "}";
    }

}

