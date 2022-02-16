package com.uniovi.notaneitor.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String dni;

    private String name;
    private String lastName;
    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Mark> marks;

    public User(String dni, String name, String lastName) {
        super();
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public String getFullName() {
        return this.name + " " + this.lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role +
                '}';
    }
}