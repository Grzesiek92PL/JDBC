package jdbc;

import java.sql.*;

public class TeacherRepository {

    // wypisuje dane wszystkich nauczycieli

    public void getAll() {
        String sql = "SELECT * FROM teachers";

        try (
                Connection connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/university", "root", "Grzesiek070892");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                System.out.println("ID: " + id);
                System.out.println("First name: " + firstName);
                System.out.println("LastName: " + lastName);

            }

        } catch (
                SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();

        }
    }

    // wypisuje nauczyciela znalezionego po id

    public void getById(int id1) {
        String sql = "SELECT * FROM teachers WHERE id = " + id1;

        try (
                Connection connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/university", "root", "Grzesiek070892");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                System.out.println("ID: " + id);
                System.out.println("First name: " + firstName);
                System.out.println("Last name: " + lastName);

            }

        } catch (
                SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();

        }
    }

    // wypisuje liczbę rekordów nauczycieli
    public void count() {

        String sql = "SELECT count(*) FROM teachers";

        try (
                Connection connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/university", "root", "Grzesiek070892");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int count = resultSet.getInt("count(*)");

                System.out.println("Count: " + count);
            }

        } catch (
                SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();

        }
    }
}









