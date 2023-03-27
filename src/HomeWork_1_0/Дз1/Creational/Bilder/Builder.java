package HomeWork_1_0.Äç1.Creational.Bilder;

public class Builder {
    public static void main(String[] args) {
        Student student=new Student.Construct("Dima")
                .setAp(academic_performance.great)
                .setAge(22).build();
        System.out.println(student);
    }
}
