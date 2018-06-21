package com.esencia.esencia.dto;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class Groups {


    private int id;

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(final Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(final List<Person> personList) {
        this.personList = personList;
    }

    private Grupo grupo;


    private List<Person> personList;
}
