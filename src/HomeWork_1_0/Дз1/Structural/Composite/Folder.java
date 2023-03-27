package HomeWork_1_0.Äç1.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    public String Name;
    public List<Folder> folders = new ArrayList();
    public List<Fileeee> files = new ArrayList<>();

    public Folder(String name) {
        Name = name;
    }
    public void addFolder(Folder folders) {
        this.folders.add(folders);
    }
    public void removeFolders(Folder folders) {
        this.folders.remove(folders);
    }
    public List<Folder> getFolders() {
        return folders;
    }

    public String getName() {
        return Name;
    }

    public void addFiles(Fileeee files) {
        this.files.add(files);
    }

    public void removeFiles(Fileeee files) {
        this.files.remove(files);
    }

    public List<Fileeee> getFiles() {
        return files;
    }

}
