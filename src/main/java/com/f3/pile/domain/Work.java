package com.f3.pile.domain;

import javax.persistence.*;

@Entity
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Version
    private Integer version;
    private String name;

    @ManyToOne
    private Project project;
}
