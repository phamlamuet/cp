import java.util.*;

public class Student implements Comparable {
    String name;
    int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name + "-" + this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && name == student.name;
    }

    /**
     * a equals c -> true
     * a.hashcode == c.hashcode
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    static void changeStudentInfo(Student a) {
        a = new Student("new", 25);
    }


    @Override
    public int compareTo(Object o) {
        //return id>id
        return 0;
    }

    




    public static void main(String[] args) {

    }
}

