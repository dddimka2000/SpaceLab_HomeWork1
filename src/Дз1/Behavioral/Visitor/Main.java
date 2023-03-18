package Äç1.Behavioral.Visitor;

public class Main {
    public static void main(String[] args) {
        Developer developer1=new FirstUser();
        Developer developer2=new SecondUser();
        Project project=new Project();
        project.beWritten(developer1);
        System.out.println("--------------");
        project.beWritten(developer2);
    }
}
