package com.mycompany.filesystem;
import java.time.LocalDateTime;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class File {
    private String name;
    private String content;
    private LocalDateTime creationDate;
    private LocalDateTime lastModified;
    private Path path;
    
    public File(String name, Directory parent) {
        if(!name.contains(".txt")) {
            this.name = name + ".txt";
        } else this.name = name;
        
        content = "";
        this.creationDate = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
    }
    
    public File(String name, String content, Directory parent){
        
        if(!name.contains(".txt")) {
            this.name = name + ".txt";
        }
        else this.name = name;
        
        this.content = content;
        this.creationDate = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
    }
    
//    public static void createFileInOS(Path filePath){
//        try {
//            if(!Files.exists(filePath)) {
//                Files.createFile(filePath);
//                System.out.println("File created: " + filePath.toString());
//            } else {
//                System.out.println("File already exists: " + filePath.toString());
//            }
//        } catch(Exception e) {
//            System.out.println("Failed to create file: " + e.getMessage());
//        }
//    }
    
    public static boolean FileExistsInOS(Path filePath){
        return Files.exists(filePath);
    }

    public String getName() {
        return name;
    }

    public void renameFile(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    public Path getPath(){
        return path;
    }
    
    public void setPath(Path path){
        this.path = path;
    }

//    public void setContent(String content) {
//        this.content = content;
//    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }
    
}
