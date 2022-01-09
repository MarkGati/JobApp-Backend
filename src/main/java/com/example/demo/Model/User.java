package com.example.demo.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 

 
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
    public String password;
    public String phone; 

    public User() {
    }

    public User(Long id, String user_name, String email, String password, String phone) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(String user_name, String email, String password, String phone) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User phone(String phone) {
        setPhone(phone);
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
        return Objects.equals(id, user.id) && Objects.equals(user_name, user.user_name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_name, email, password, phone);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user_name='" + getUser_name() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", phone='" + getPhone() + "'" +
            "}";
    }

}

