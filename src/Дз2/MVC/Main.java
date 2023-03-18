package Äç2.MVC;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 20);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setName("Jane Doe");
        controller.setAge(22);
        controller.updateView();
    }
}