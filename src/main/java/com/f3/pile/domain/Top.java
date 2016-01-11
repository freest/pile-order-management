package com.f3.pile.domain;

import javax.persistence.*;
import java.util.List;

public class Top {
    @Version
    private Integer version;
    private List<Project> projects;
}
