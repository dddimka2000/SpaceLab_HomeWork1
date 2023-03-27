package HomeWork_1_0.Äç2.MVVM;

public class ViewModel {
    private Model model;
    private View view;

    public ViewModel(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
        view.show();
    }
}
