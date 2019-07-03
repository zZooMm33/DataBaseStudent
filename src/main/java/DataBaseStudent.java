import java.sql.Connection;
import java.util.UUID;

public class DataBaseStudent {

    private String nameTable;

    public DataBaseStudent(String nameTable) {
        this.nameTable = nameTable;
    }

    public void addStudent(Connection connection, Student student){

    }

    public void deleteStudent(Connection connection, UUID id){

    }

    public void updateStudent(Connection connection, Student student){

    }

    public String printTable(Connection connection){

        return "";
    }

    public Student getStudent(Connection connection, UUID id){

        return new Student();
    }

    public void clearTableStudent(Connection connection){

    }

}
