package jdbc;

import java.sql.*;

public class StudentRepository {

    public void getAll() {
        String sql = "SELECT * FROM students";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/university", "root", "Grzesiek070892");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int indexNumber = resultSet.getInt("index_number");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int term = resultSet.getInt("term");
                int year = resultSet.getInt("enrollment_year");

                System.out.println("Index number: " + indexNumber);
                System.out.println("First name: " + firstName);
                System.out.println("Last name: " + lastName);
                System.out.println("Term: " + term);
                System.out.println("Year: " + year);
                System.out.println('\n');

            }


        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();

        }
    }

    public void getByYear(int yearParam) {
        String sql = "SELECT * FROM students where enrollment_year = " + yearParam;

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/university", "root", "Grzesiek070892");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int indexNumber = resultSet.getInt("index_number");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int term = resultSet.getInt("term");
                int year = resultSet.getInt("enrollment_year");

                System.out.println("Index number: " + indexNumber);
                System.out.println("First name: " + firstName);
                System.out.println("Last name: " + lastName);
                System.out.println("Term: " + term);
                System.out.println("Year: " + year);
                System.out.println('\n');
            }
        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();

        }

    }


}


