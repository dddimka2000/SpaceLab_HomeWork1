package HomeWork_1_0.Äç1.Creational.Prototype;

import java.util.List;

public class Marks {
    public List<Integer> marks;

    public Marks(List<Integer> marks) {
        this.marks = marks;
    }
    public Marks clone(){
        Marks clone=new Marks(marks);
        return clone;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "marks=" + marks +
                '}';
    }
}
