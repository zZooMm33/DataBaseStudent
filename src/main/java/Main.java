import java.sql.*;

public class Main {
    private static String dataBaseUrl = "jdbc:sqlite:/Users/zzoomm/Desktop/Git/Java/DataBaseStudentGradle/Student.db";

    // если потребуется добавить к getConnection
    private static String dataBaseUser = "zZooMm";
    private static String dataBasePassword = "Hp0qpVOuumLj";

    public static void main(String[] args) {

        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dataBaseUrl);
            if (connection != null){

                Statement statement = connection.createStatement();
                DataBaseStudent dataBaseStudent = new DataBaseStudent("STUDENTS");


                //dataBaseStudent.addStudent(statement, new Student("New", "Newnew", 123));
                //System.out.println(dataBaseStudent.printTable(statement));

                connection.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
