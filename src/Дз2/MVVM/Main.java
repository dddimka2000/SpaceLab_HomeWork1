package Äç2.MVVM;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();

        ViewModel viewModel = new ViewModel(model, view);

        view.setViewModel(viewModel);
        view.show();
    }
}

