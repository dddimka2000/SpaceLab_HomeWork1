package Äç1.Structural.Proxy;

public class Proxy implements Run {
    private String url;
    private Project project;

    public Proxy(String url) {
        this.url = url;

    }

    @Override
    public void run() {
        if (project == null) {
            project = new Project(url);
        }
        project.run();
    }
}
