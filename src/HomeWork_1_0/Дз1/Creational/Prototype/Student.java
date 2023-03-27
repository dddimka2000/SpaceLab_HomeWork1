package HomeWork_1_0.Äç1.Creational.Prototype;

import java.util.List;
public class Student {
    private String student;
    private Marks marks;

    public Student(String student, Marks marks) {
        this.student = student;
        this.marks = marks;
    }
    public Student(String student, List<Integer> marks_list) {
        this.student = student;
        Marks marks=new Marks(marks_list);
        this.marks = marks;
    }
    public Student copy() {
        Student copy=new Student(student,marks.clone());
        return copy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student='" + student + '\'' +
                ", marks=" + marks +
                '}';
    }
}
