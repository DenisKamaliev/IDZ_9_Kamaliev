import java.util.Objects;

public class Human
{
    private String firstname;
    private String secondname;
    private String fathersname;
    private int age;
    private Gender gender;

    public Human(String firstname, String secondname, String fathersname, int age, Gender gender)
    {
        this.firstname = firstname;
        this.secondname = secondname;
        this.fathersname = fathersname;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(firstname, human.firstname) && Objects.equals(secondname, human.secondname) && Objects.equals(fathersname, human.fathersname) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, secondname, fathersname, age, gender);
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFathersname(String lastname) {
        this.fathersname = lastname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getSecondname() {
        return secondname;
    }
}