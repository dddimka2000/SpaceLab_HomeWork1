package Äç2.MVC;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getAge());
    }

    public void setName(String name) {
        model.setName(name);
    }

    public void setAge(int age) {
        model.setAge(age);
    }
}

