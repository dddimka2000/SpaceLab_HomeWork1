package HomeWork_1_0.��1.Behavioral.Template;

public abstract class WebsiteTemplate {
        public void showPage(){
            System.out.println("Welcome");
            show();
            System.out.println("Bye");
        }
        abstract void show();

}
