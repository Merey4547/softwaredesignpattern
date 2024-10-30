package assignment5task3;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(String name, int age, String course) {
        students.add(new Student(name, age, course));
    }

    public void updateStudent(int index, String name, int age, String course) {
        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
        }
    }
}
