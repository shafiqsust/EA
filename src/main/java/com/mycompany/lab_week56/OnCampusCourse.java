package com.mycompany.lab_week56;

import org.eclipse.persistence.annotations.Cache;


import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("ON_CAMPUS")
@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Cache(usage = org.eclipse.persistence.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class OnCampusCourse extends Course {
    private String room;

    private Integer capacity;

    // constructors, getters, and setters

    public OnCampusCourse(String room, Integer capacity) {
        this.room = room;
        this.capacity = capacity;
    }

    public OnCampusCourse(Long id, String title, Date startDate, String professorName, String room, Integer capacity) {
        super(id, title, capacity, startDate, professorName);
        this.room = room;
        this.capacity = capacity;
    }

    public OnCampusCourse() {

    }
}
