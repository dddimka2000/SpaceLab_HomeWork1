package HomeWork_1_0.Äç1.Behavioral.Visitor;

public class SecondUser implements Developer{
    @Override
    public void Create(DataBase dataBase) {
        System.out.println("2 create database");
    }

    @Override
    public void Create(ProjectClass projectClass) {
        System.out.println("2 create project class");
    }

    @Override
    public void Create(Test test) {
        System.out.println("2 create test");
    }
}
