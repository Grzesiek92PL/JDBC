package jdbc;

import java.sql.*;


public class Main {

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        // studentRepository.getAll();
        // studentRepository.getByYear(2015);


        TeacherRepository teacherRepository = new TeacherRepository();
        // teacherRepository.getAll();
        // teacherRepository.getById(1);
        //teacherRepository.count();

        MovieRepository movieRepository = new MovieRepository();
        //movieRepository.createDatabase();
       // movieRepository.createTable();
        //movieRepository.deleteTable();
        //movieRepository.delete(1);
        movieRepository.getAll();

    }
}
