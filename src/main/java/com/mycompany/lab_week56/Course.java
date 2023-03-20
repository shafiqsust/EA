package com.mycompany.lab_week56;
import java.util.Date;

import javax.persistence.*;

enum CourseType {
    ON_CAMPUS,
    DISTANCE_EDUCATION
}
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "COURSE_TYPE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Date startDate;

    private String professorName;

    private int capacity;
    public Course() {

    }

    public Course(Long id, String title,int capacity, Date startDate, String professorName) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.professorName = professorName;
    }

    // constructors, getters, and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}

