package com.mycompany.lab_week56;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("DISTANCE_EDUCATION")
@Cacheable(false)
public class DistanceEducationCourse extends Course {
    private static final int capacity = 0;
    private String examProfessor;

    @ElementCollection
    private List<Date> webinarSessionDates;

    public DistanceEducationCourse(Long id, String title, Date startDate, String professorName) {
        super(id, title,capacity, startDate, professorName);
    }

    public DistanceEducationCourse() {
        super();
    }

    public String getExamProfessor() {
        return examProfessor;
    }

    public void setExamProfessor(String examProfessor) {
        this.examProfessor = examProfessor;
    }

    public List<Date> getWebinarSessionDates() {
        return webinarSessionDates;
    }

    public void setWebinarSessionDates(List<Date> webinarSessionDates) {
        this.webinarSessionDates = webinarSessionDates;
    }
}
