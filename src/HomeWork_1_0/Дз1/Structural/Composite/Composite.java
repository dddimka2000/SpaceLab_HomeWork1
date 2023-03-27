package HomeWork_1_0.Äç1.Structural.Composite;

public class Composite {
    public static void main(String[] args) {

        Folder folder = new Folder("Jack");

        folder.addFolder(new Folder("Jack1"));
        folder.addFolder(new Folder("Jack2"));

        Folder folder3=new Folder("Jack3");
        folder.addFolder(folder3);

        System.out.println(folder.getName());
        System.out.println(folder.getFolders().stream().map(Folder::getName).toList());

        folder.removeFolders(folder3);
        System.out.println(folder.getFolders().stream().map(Folder::getName).toList());
    }
}
