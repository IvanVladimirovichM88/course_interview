package lesson5.utils;

import lesson5.dao.StudentDAO;
import lesson5.entities.Student;


public class MainClass5 {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        Student student = new Student("Student 2", Byte.valueOf("2"));

//        studentDAO.create( student);

        System.out.println(studentDAO.findById(1L)) ;
    }
}
