package ��2.MVP;

import ��1.Creational.Prototype.Student;

public class Main_MVP {
    public static void main(String[] args) {
        Student_MVP model = new Student_MVP("John", 20);
        ConsoleStudentView_MVP view = new ConsoleStudentView_MVP(model.getName(),model.getAge());
        StudentPresenter_MVP presenter = new StudentPresenter_MVP(model, view);

        presenter.updateView();

        view.setName("Jane Doe");
        view.setAge(22);

        presenter.updateModel();
        presenter.updateView();
    }
}
