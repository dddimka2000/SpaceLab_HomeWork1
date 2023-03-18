package Äç1.Behavioral.Visitor;

public class Project implements ProjectElement {
    ProjectElement[] projectElements;

    public Project() {
        projectElements = new ProjectElement[]{
                new ProjectClass(),
                new DataBase(),
                new Test()
        };
    }

    @Override
    public void beWritten(Developer developer) {
        for(ProjectElement projectElement:projectElements){
            projectElement.beWritten(developer);
        }
    }
}
