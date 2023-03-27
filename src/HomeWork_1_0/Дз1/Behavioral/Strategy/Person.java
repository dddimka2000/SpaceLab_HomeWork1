package HomeWork_1_0.Äç1.Behavioral.Strategy;

public class Person {
    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void doSomething() {
        activity.doSomething();
    }
}
