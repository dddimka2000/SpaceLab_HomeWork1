package HomeWork_1_0.Äç1.Structural.Proxy;

public class Project implements Run{
    String url;

    public Project(String url) {
        this.url = url;
        load();
    }
    private void load(){
        System.out.println("load "+url);
    }

    @Override
    public void run() {
        System.out.println("Run  "+ url);

    }
}
