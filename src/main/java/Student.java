import java.util.UUID;

public class Student {
    private UUID id;
    private String firstName;
    private String secondName;
    private int age;

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
        this.id = UUID.randomUUID();
        this.firstName = "";
        this.secondName = "";
        this.age = 0;
    }

    public Student(String firstName, String secondName, int age) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id.toString() +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}
