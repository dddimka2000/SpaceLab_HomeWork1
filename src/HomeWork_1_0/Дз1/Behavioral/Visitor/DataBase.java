package HomeWork_1_0.��1.Behavioral.Visitor;

public class DataBase implements ProjectElement{
    @Override
    public void beWritten(Developer developer) {
        developer.Create(this);
    }
}