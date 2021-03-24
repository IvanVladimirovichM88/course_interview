package lesson5.dao;

import lesson5.entities.Student;
import lesson5.utils.HibernateSessionFactory;
import org.hibernate.Session;

public class StudentDAO {

    private final Session session;

    public StudentDAO() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    public void create(Student student){

        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

    }

    public void update(Student student){

        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
    }

    public Student findById(Long id){
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    public void delete(Student student){
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
    }
}
