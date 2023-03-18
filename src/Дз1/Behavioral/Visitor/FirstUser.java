package Äç1.Behavioral.Visitor;

public class FirstUser  implements Developer{
    @Override
    public void Create(DataBase dataBase) {
        System.out.println("1 create database");
    }

    @Override
    public void Create(ProjectClass projectClass) {
        System.out.println("1 create project class");
    }

    @Override
    public void Create(Test test) {
        System.out.println("1 create test");
    }
}