package pl.ave.rpg.file;

import pl.ave.rpg.exception.DataExportException;
import pl.ave.rpg.exception.DataImportException;
import pl.ave.rpg.model.Library;

import java.io.*;

public class SerializableFileManager implements FileManager {
    private static final  String FILE_NAME = "Library.o";

    public void exportData(Library library) {
        try(FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(library);
        }catch (FileNotFoundException e){
            throw new DataExportException("Brak pliku "+FILE_NAME);
        }catch(IOException e){
            throw new DataExportException("Bład zapisu danych do pliku "+FILE_NAME);
        }
    }

    public Library importData() {
        try(FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ){
            return (Library) ois.readObject();
        }catch(FileNotFoundException e){
            throw new DataImportException("Brak pliku "+FILE_NAME);
        }catch(IOException e){
            throw new DataImportException("Błąd odczytu pliku "+FILE_NAME);
        }catch (ClassNotFoundException e){
            throw new DataImportException("Niezgodny typ danych w pliku " + FILE_NAME);
        }
    }
}
