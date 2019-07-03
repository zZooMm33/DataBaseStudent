import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class DataBaseStudentTest {

    private static String dataBaseName = "STUDENT";

    private static String dataBaseUrl = "jdbc:h2:tcp://localhost/~/test";
    private static String dataBaseUser = "zZooMm";
    private static String dataBasePassword = "Hp0qpVOuumLj";

    @Test
    public void update() throws SQLException {
        Connection connection = DriverManager.getConnection(dataBaseUrl, dataBaseUser, dataBasePassword);
        DataBaseStudent dataBaseStudent = new DataBaseStudent(dataBaseName);

        if (connection != null){

            Statement statement = connection.createStatement();

            dataBaseStudent.clearTableStudent(connection);

            Student student = new Student("Test", "Test", 10);
            dataBaseStudent.addStudent(connection, student);

            student.setFirstName("TEST");
            dataBaseStudent.updateStudent(connection, student);

            assertEquals(student.toString(), dataBaseStudent.getStudent(connection, student.getId()));

            dataBaseStudent.deleteStudent(connection, student.getId());

            connection.close();
        }
    }

    @Test
    public void getStudent() throws SQLException {
        Connection connection = DriverManager.getConnection(dataBaseUrl, dataBaseUser, dataBasePassword);
        DataBaseStudent dataBaseStudent = new DataBaseStudent(dataBaseName);

        if (connection != null){

            Statement statement = connection.createStatement();

            dataBaseStudent.clearTableStudent(connection);

            Student student = new Student("Test", "Test", 10);
            dataBaseStudent.addStudent(connection, student);

            assertEquals(student.toString(), dataBaseStudent.getStudent(connection, student.getId()));

            dataBaseStudent.deleteStudent(connection, student.getId());

            connection.close();
        }

    }

    @Test
    public void clearTable() throws SQLException {

        Connection connection = DriverManager.getConnection(dataBaseUrl, dataBaseUser, dataBasePassword);
        DataBaseStudent dataBaseStudent = new DataBaseStudent(dataBaseName);

        if (connection != null){

            Statement statement = connection.createStatement();

            dataBaseStudent.clearTableStudent(connection);

            assertEquals("", dataBaseStudent.printTable(connection));

            connection.close();
        }
    }
}