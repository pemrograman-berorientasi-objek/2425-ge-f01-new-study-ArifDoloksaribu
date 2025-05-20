package pbo.driver;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.*;

import pbo.model.*;

// 12S23004 - Poppy Sibuea
// 12S23026 - Arif Doloksaribu

public class Driver {
    private EntityManager entityManager;
    public Driver(EntityManager entityManager){
        this.entityManager = entityManager; 
    }

    public void deletetable(){
        String [] query = {
            "DELETE FROM Student",
            "DELETE FROM Course"
        };
        entityManager.getTransaction().begin();
        for (String q : query) {
            entityManager.createQuery(q).executeUpdate();
        }
        entityManager.getTransaction().commit();
    }


    public void addStudent(String[] data){
        entityManager.getTransaction().begin();
        Student tempStudent;
        if((tempStudent = entityManager.find(Student.class, data[1])) == null){
            Student student = new Student(data[1], data[2], data[3]);
            entityManager.persist(student);
        }
        else{
            if(!tempStudent.getNim().equals(data[1])){
                Student student = new Student(data[1], data[2], data[3]);
                entityManager.persist(student);
            }
        }
        entityManager.getTransaction().commit();
    }


    public void studentall(){
        String query = "SELECT s FROM Student s ORDER BY s.nim asc";
        List<Student> students = entityManager.createQuery(query, Student.class).getResultList();
        for(Student s : students){
            System.out.println(s);
        }
    }

    public void addCourse(String[] data){
        entityManager.getTransaction().begin();
        Course tempCourse;
        if((tempCourse = entityManager.find(Course.class, data[1])) == null){
            Course courses = new Course(data[1], data[2], data[3], Integer.parseInt(data[4]));
            entityManager.persist(courses);
        }else{
            if(!tempCourse.getKode().equals(data[1])){
                Course courses = new Course(data[1], data[2], data[3], Integer.parseInt(data[4]));
                entityManager.persist(courses);
            }
        }
        entityManager.getTransaction().commit();
    }

    public void courseall(){
        String query = "SELECT c FROM Course c ORDER BY c.semester asc";
        List<Course> courses = entityManager.createQuery(query, Course.class).getResultList();
        for(Course c : courses){
            System.out.println(c);
        }
    }

    public void enroll(String[] data){
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, data[1]);
        Course courses = entityManager.find(Course.class, data[2]);
        if(student != null && courses != null){
            student.getCourses().add(courses);
            courses.getStudents().add(student);
            entityManager.persist(student);
            entityManager.persist(courses);
            entityManager.getTransaction().commit();
        }else{
            entityManager.getTransaction().rollback();
        }
    }

    public void show(String[] data){
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, data[1]);
        if(student != null){
            System.out.println(student);
            List<Course> courses = student.getCourses();
            Collections.sort(courses, Comparator.comparing(Course::getSemester));
              for(Course c : courses){
                System.out.println(c);
            }
        }
        entityManager.getTransaction().commit();
    }
}

