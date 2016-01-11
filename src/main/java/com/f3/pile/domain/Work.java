package com.f3.pile.domain;

import javax.persistence.*;

@Entity
public class Work {
    @Id
    private Integer id;

    @Version
    private Integer version;
    private String name;
}
