package HomeWork_1_0.Äç2.MVVM;

public class View {
    private ViewModel viewModel;

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void show() {
        System.out.println("Name: " + viewModel.getName());
    }
}
