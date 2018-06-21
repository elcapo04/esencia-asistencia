package com.esencia.esencia.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }



    public int getDni() {
        return dni;
    }

    public void setDni(final int dni) {
        this.dni = dni;
    }

    @Id
    @Column(name = "person_id")
    private int id;
    private String surname;
    private String name;
    private Date dateOfBirth;
    private int dni;
    private Type type;
}
