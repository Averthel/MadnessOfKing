package pl.ave.rpg.file;


import pl.ave.rpg.model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
