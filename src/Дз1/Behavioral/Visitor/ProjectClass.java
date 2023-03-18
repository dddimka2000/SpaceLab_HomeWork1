package Äç1.Behavioral.Visitor;

public class ProjectClass implements ProjectElement{
    @Override
    public void beWritten(Developer developer) {
        developer.Create(this);
    }
}
