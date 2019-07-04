import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class DataBaseStudentTest {

    private static String dataBaseName = "STUDENTS";

    private static String dataBaseUrl = "jdbc:sqlite:/Users/zzoomm/Desktop/Git/Java/DataBaseStudentGradle/Student.db";

    // если потребуется добавить к getConnection
    private static String dataBaseUser = "zZooMm";
    private static String dataBasePassword = "Hp0qpVOuumLj";

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection(dataBaseUrl);
        DataBaseStudent dataBaseStudent = new DataBaseStudent(dataBaseName);

        if (connection != null){

            Statement statement = connection.createStatement();

            dataBaseStudent.clearTableStudent(statement);

            Student student = new Student("Test", "Test", 10);
            dataBaseStudent.addStudent(statement, student);

            student.setAge(999999999);
            dataBaseStudent.updateStudent(statement, student);

            assertEquals(student.toString(), dataBaseStudent.getStudent(statement, student.getId()).toString());

            dataBaseStudent.deleteStudent(statement, student.getId());

            connection.close();
        }
    }

    @Test
    public void getStudent() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection(dataBaseUrl);

        DataBaseStudent dataBaseStudent = new DataBaseStudent(dataBaseName);

        if (connection != null){

            Statement statement = connection.createStatement();

            dataBaseStudent.clearTableStudent(statement);

            Student student = new Student("Test", "Test", 10);
            dataBaseStudent.addStudent(statement, student);

            assertEquals(student.toString(), dataBaseStudent.getStudent(statement, student.getId()).toString());

            dataBaseStudent.deleteStudent(statement, student.getId());

            connection.close();
        }

    }

    @Test
    public void clearTable() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection(dataBaseUrl);

        DataBaseStudent dataBaseStudent = new DataBaseStudent(dataBaseName);

        if (connection != null){

            Statement statement = connection.createStatement();

            dataBaseStudent.clearTableStudent(statement);

            assertEquals("", dataBaseStudent.printTable(statement));

            connection.close();
        }
    }
}