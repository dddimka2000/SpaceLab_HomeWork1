package Äç1.Creational.Bilder;

public class Student {
    private String name;
    private int age;
    private academic_performance ap;

    private Student(Construct construct) {
        this.name = construct.name;
        this.age = construct.age;
        this.ap = construct.ap;
    }

    static class Construct {
        private String name;
        private int age;
        private academic_performance ap;

        public Construct(String name)
        {
            this.name = name;
        }

        public Construct setAge(int age) {
            this.age = age;
            return this;
        }

        public Construct setAp(academic_performance ap) {
            this.ap = ap;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ap=" + switch (ap){
            case satisfactorily -> "satisfactorily";
            case good -> "good";
            case great -> "great";
        } +
                '}';
    }
}
