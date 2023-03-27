package HomeWork_1_0.Äç1.Creational.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public static void main(String[] args){
        List<Integer> marks=new ArrayList<>();
        marks.add(60);
        marks.add(100);
        Marks marks1=new Marks(marks).clone();
        Student student1 = new Student("Mark",marks1);
        Student student2 = new Student("Mark",marks);
        Student student3 = student1.copy();
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}
