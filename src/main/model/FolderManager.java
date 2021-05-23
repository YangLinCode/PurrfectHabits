package model;

import model.exceptions.HabitAlreadyExistsException;

import java.io.File;
import java.io.IOException;

public class FolderManager {
    private String destination;

    public FolderManager(String destination) {
        this.destination = destination;
    }

    public String getPath() {
        return destination;
    }

    public void createHabitDirectory(String folderName) throws HabitAlreadyExistsException {
        createHabitFolder(folderName);
        createGalleryFolder(folderName);
        createJsonFile(folderName);
    }

    private void createHabitFolder(String folderName) throws HabitAlreadyExistsException {
        String path = destination + "\\" + folderName;
        File folder = new File(path);

        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Habit folder has been created successfully");
            } else {
                System.out.println("Habit folder has failed to be created");
            }
        } else {
            System.out.println("Habit folder already exists");
            throw new HabitAlreadyExistsException();
        }
    }

    private void createGalleryFolder(String folderName) {
        String path = destination + "\\" + folderName + "\\" + folderName + "_Awards";
        File folder = new File(path);

        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Gallery folder has been created successfully");
            } else {
                System.out.println("Gallery folder has failed to be created");
            }
        } else {
            System.out.println("Gallery folder already exists");
        }
    }

    private void createJsonFile(String folderName) {
        String path = destination + "\\" + folderName + "\\" + folderName + "_Details.json";

        try {
            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteHabitDirectory(String folderName) {
        String path = destination + "\\" + folderName;
        File folder = new File(path);

        deleteHabitDirectoryHelper(folder);
    }

    private void deleteHabitDirectoryHelper(File source) {
        File[] files = source.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                deleteHabitDirectoryHelper(file);
            }

            file.delete();
        }

        source.delete();
    }
}
