package com.f3.pile.domain;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Version
    private Integer version;
    private String name;

    @ManyToOne
    private Employee foreman;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getForeman() {
        return foreman;
    }

    public void setForeman(Employee foreman) {
        this.foreman = foreman;
    }
}
