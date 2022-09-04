package jdbc;

import java.sql.*;

public class MovieRepository {

    // tworzy baze danych o nazwie Hollywood
    public void createDatabase() {
        String sql = "CREATE DATABASE IF NOT EXISTS Hollywood";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306", "root", "Grzesiek070892");
             Statement statement = connection.createStatement();
        ) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }

    // tworzy tabele movies z polami
    // id of type INTEGER AUTO INCREMENT,title of type VARCHAR (255), genre of type VARCHAR (255),yearOfRelease of type INTEGER
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS movies (id INTEGER AUTO_INCREMENT, title VARCHAR(255), genre VARCHAR(255), yearOfRelease INTEGER, PRIMARY KEY(id))";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Hollywood", "root", "Grzesiek070892");
             Statement statement = connection.createStatement();
        ) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }

    // usuwa cala tabele
    public void deleteTable() {
        String sql = "DROP TABLE IF EXISTS movies";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Hollywood", "root", "Grzesiek070892");
             Statement statement = connection.createStatement();
        ) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }

    // dodac trzy filmy recznie przez workbench

    // usuwa film po id
    public void delete(int id) {
        String sql = "DELETE FROM movies where id=" + id;

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Hollywood", "root", "Grzesiek070892");
             Statement statement = connection.createStatement();
        ) {
            int rows = statement.executeUpdate(sql);

            System.out.println("Rows deleted: " + rows);
        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }

    // wypisuje wszystkie filmy w bazie
    public void getAll() {
        String sql = "SELECT * from movies";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Hollywood", "root", "Grzesiek070892");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                int yearOfRelease = resultSet.getInt("yearOfRelease");

                System.out.println("id: " + id);
                System.out.println("title: " + title);
                System.out.println("genre: " + genre);
                System.out.println("yearOfRelease: " + yearOfRelease);
                System.out.println('\n');
            }
        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }

}