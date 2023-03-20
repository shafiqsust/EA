package com.mycompany.lab_week56;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class Main {
    

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_lab_week2_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        // create and persist a Student instance
        Student student = new Student();
        student.setName("John Smith");
        student.setGpa(3.5f);
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        //JPQL
        String jpql = "SELECT s FROM Student s WHERE s.gpa > 3.5 AND s.courseAttending.capacity > 30";
        TypedQuery<Student> query = em.createQuery(jpql, Student.class);
        List<Student> students = query.getResultList();

        //NamedQuery:
        TypedQuery<Student> query2 = em.createNamedQuery("CanGraduate", Student.class);
        List<Student> students2 = query.getResultList();

        //CriteriaAPI:
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        Join<Student, Course> course = root.join("courseAttending");
        Predicate p1 = cb.lessThan(root.get("gpa"), 3.0);
        Predicate p2 = cb.equal(course.get("professorName"), "Najeeb");
        //Predicate p3 = cb.isInstanceOf(course, DistanceEducation.class);
        Predicate p3 = cb.equal(course.type(), DistanceEducation.class);
        cq.where(p1, p2, p3);
        TypedQuery<Student> query3 = em.createQuery(cq);
        List<Student> students3 = query.getResultList();

    }
}