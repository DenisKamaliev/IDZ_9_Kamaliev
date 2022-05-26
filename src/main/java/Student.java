import java.util.Objects;

public class Student extends Human
{
    private String university;
    private String department;
    private String special;
    public Student(String firstname, String secondname, String fathersname, String university, String department,
                   String special, int age, Gender people) {
        super(firstname, secondname, fathersname, age, people);
        this.university = university;
        this.department = department;
        this.special = special;
    }

    public String getDepartment() {
        return department;
    }

    public String getSpecial() {
        return special;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public Gender getGender() {
        return super.getGender();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    public String getFathersname() {
        return super.getFathersname();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(university, student.university) && Objects.equals(department, student.department) && Objects.equals(special, student.special);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, department, special);
    }
}
