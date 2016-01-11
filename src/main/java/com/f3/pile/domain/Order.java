package com.f3.pile.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Table(name = "_Order")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    private String name;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Employee foreman;
    private Date startDate;
    private Date endDate;

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getForeman() {
        return foreman;
    }

    public void setForeman(Employee foreman) {
        this.foreman = foreman;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Date> getDates() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        List<Date> dates = new ArrayList<Date>();
        for(; !calendar.getTime().after(endDate); calendar.add(Calendar.DATE, 1)){
            dates.add(calendar.getTime());
        }
        return dates;
    }
    public List<String> getWorks() {
        return Arrays.asList("ф620-15", "ф620-25,7");
    }
}
