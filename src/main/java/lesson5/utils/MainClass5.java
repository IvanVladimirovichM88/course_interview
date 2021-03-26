package lesson5.utils;

import lesson5.dao.StudentDAO;
import lesson5.entities.Student;


public class MainClass5 {

    final static int MAX_STUDENT = 1000;

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        String studentName = "Student";


        for (int i=0; i<MAX_STUDENT; i++){

            studentDAO.create(new Student(studentName+i, Byte.valueOf("5")));
        }
        System.out.println(studentDAO.findById(1L)) ;
    }
}
