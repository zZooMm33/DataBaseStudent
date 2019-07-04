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

                System.out.println("Вывод БД");
                System.out.println(dataBaseStudent.printTable(statement));

                dataBaseStudent.addStudent(statement, new Student("Yura", "Agapov", 21));
                dataBaseStudent.addStudent(statement, new Student("Ya", "Ya", 19));

                Student student = new Student("Test", "Test", 21);
                dataBaseStudent.addStudent(statement, student);

                System.out.println("Вывод БД (пустая)");
                System.out.println(dataBaseStudent.printTable(statement));

                student.setAge(100).setFirstName("NewName");
                dataBaseStudent.updateStudent(statement, student);

                System.out.println("Вывод БД (добавили 3 ст)");
                System.out.println(dataBaseStudent.printTable(statement));

                System.out.println("Вывод студента по id");
                Student get_student = dataBaseStudent.getStudent(statement, student.getId());
                System.out.println(get_student.toString() + "\n");

                dataBaseStudent.deleteStudent(statement, student.getId());

                System.out.println("Вывод БД (удаление)");
                System.out.println(dataBaseStudent.printTable(statement));

                dataBaseStudent.clearTableStudent(statement);

                System.out.println("Вывод БД (очистка)");
                System.out.println(dataBaseStudent.printTable(statement));

                connection.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
