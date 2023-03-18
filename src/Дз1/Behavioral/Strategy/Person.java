package Äç1.Behavioral.Strategy;

public class Person {
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void doSomething() {
        activity.doSomething();
    }
}
