package com.mycompany.lab_week56;

import org.eclipse.persistence.annotations.OptimisticLocking;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Cacheable;

import static javax.persistence.LockModeType.PESSIMISTIC_WRITE;

//@NamedQuery(name = "CanGraduate", query = "SELECT s FROM Student s WHERE s.gpa >= 3.0 AND size(s.coursesAttended) >= 9 AND s.courseAttending IS NULL")
@NamedQuery(name = "CanGraduate", query = "SELECT s FROM Student s WHERE s.gpa >= 3.0 AND size(s.coursesAttended) >= 9 AND s.courseAttending IS NULL", hints = @QueryHint(name = "javax.persistence.lock.timeout", value = "5000"), lockMode = PESSIMISTIC_WRITE)
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float gpa;

    @ManyToOne
    private Course courseAttending;

    @ManyToMany
    private List<Course> coursesAttended = new ArrayList<>();

    @Version
    private Integer version;

    // constructors, getters and setters

    public Student(Long id, String name, float gpa, Course courseAttending, List<Course> coursesAttended) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.courseAttending = courseAttending;
        this.coursesAttended = coursesAttended;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Course getCourseAttending() {
        return courseAttending;
    }

    public void setCourseAttending(Course courseAttending) {
        this.courseAttending = courseAttending;
    }

    public List<Course> getCoursesAttended() {
        return coursesAttended;
    }

    public void setCoursesAttended(List<Course> coursesAttended) {
        this.coursesAttended = coursesAttended;
    }
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}

