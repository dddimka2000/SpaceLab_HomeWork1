package HomeWork_1_0.Äç1.Behavioral.Template;

public class Main {
    public static void main(String[] args) {
        WebsiteTemplate read=new Read();
        WebsiteTemplate sleep=new Sleep();
        read.showPage();
        System.out.println("--------------");
        sleep.showPage();
    }
}
