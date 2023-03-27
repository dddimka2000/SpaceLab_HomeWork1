package HomeWork_1_0.Äç1.Behavioral.Visitor;

public class Test implements ProjectElement{
    @Override
    public void beWritten(Developer developer) {
        developer.Create(this);
    }
}