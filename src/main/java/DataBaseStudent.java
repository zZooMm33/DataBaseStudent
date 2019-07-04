import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class DataBaseStudent {

    private String nameTable;

    public DataBaseStudent(String nameTable) {
        this.nameTable = nameTable;
    }

    public void addStudent(Statement statement, Student student) throws SQLException {

        String sql = "INSERT INTO " + nameTable +  " values ('" + student.getId() + "', '" +student.getFirstName() + "', '" + student.getSecondName() + "', " + student.getAge() + ");";
        statement.execute(sql);
    }

    public void deleteStudent(Statement statement, String id) throws SQLException {
        String sql = "DELETE FROM " + nameTable +  " WHERE ID = '" + id.toString() +  "'";
        statement.execute(sql);
    }

    public void updateStudent(Statement statement, Student student) throws SQLException {
        //UPDATE Customers SET rating = 200 WHERE snum = 1001;
        //String sql = "UPDATE " + nameTable +  " SET AGE = " + student.getAge() + " WHERE ID = '" + student.getId() + "'";
        String sql = "UPDATE " + nameTable +  " SET FIRST_NAME = '" + student.getFirstName() + "', SECOND_NAME = '" + student.getSecondName() + "', AGE = " + student.getAge() + " WHERE ID = '" + student.getId() + "'";
        statement.execute(sql);
    }

    public String printTable(Statement statement) throws SQLException {

        String result = "";
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nameTable);

        while (resultSet.next()){
            result += resultSet.getString("ID") + " " + resultSet.getString("FIRST_NAME") + " " + resultSet.getString("SECOND_NAME") + " " + resultSet.getInt("AGE") + "\n";
        }

        return result;
    }

    public Student getStudent(Statement statement, String id) throws SQLException {

        Student student = new Student();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nameTable + " WHERE ID = '" + id + "'");

        while (resultSet.next()){
            student.setId(resultSet.getString("ID"));
            student.setFirstName(resultSet.getString("FIRST_NAME"));
            student.setSecondName(resultSet.getString("SECOND_NAME"));
            student.setAge(resultSet.getInt("AGE"));
        }

        return student;
    }

    public void clearTableStudent(Statement statement) throws SQLException {
        String sql = "DELETE FROM " + nameTable;
        statement.execute(sql);
    }

}
