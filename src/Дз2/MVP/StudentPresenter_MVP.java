package Äç2.MVP;

public class StudentPresenter_MVP {
    private Student_MVP model;
    private ConsoleStudentView_MVP view;

    public StudentPresenter_MVP(Student_MVP model, ConsoleStudentView_MVP view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.display();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public void setAge(int age) {
        model.setAge(age);
    }

    public void updateModel() {
        model.setName(view.getName());
        model.setAge(view.getAge());
    }
}


