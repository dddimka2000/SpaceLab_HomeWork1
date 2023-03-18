package Äç1.Behavioral.State;

public class Person implements Activity{
    Activity activity;

    public Person(Activity activity) {
        this.activity = activity;
    }

    void changeActivity(){
        if(activity instanceof Eat){
            activity=new Run();
        } else if (activity instanceof Run){
            activity=new Sleep();
        }else if (activity instanceof Sleep){
            activity=new Study();
        }else if (activity instanceof Study){
            activity=new Eat();
        }
    }
    @Override
    public void doSomething() {
        activity.doSomething();
    }
}
