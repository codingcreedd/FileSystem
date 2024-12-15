package com.mycompany.filesystem;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Directory {
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime lastModified;
    private Directory parent;
    
    
    private int size;
    private int subDirectoryCount;
    private int fileCount;
    
    
    private Entry head; 
    
    public Directory(String name) {
        this(name, null);
    }
    
    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.creationDate = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
        this.fileCount = 0;
        this.subDirectoryCount = 0;
        this.head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public Entry getHead(){
        if(isEmpty()){
            return null;
        }
        
        return head;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Directory getParent(){
        return this.parent;
    }
    
    public int getFileCount(){
        return fileCount;
    }
    
    public int getSubDirectoryCount(){
        return subDirectoryCount;
    }
    
    //add file to the directory
    public void addFile(File file){
        
        if(isEmpty()) {
            Entry newFile = new Entry(file);
            this.head = newFile;
            fileCount++;
            return;
        }
        
        Entry newFile = new Entry(file);
        Entry current = this.head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        
        current.setNext(newFile);
        this.size++;
        fileCount++;
        lastModified = LocalDateTime.now();
    }
    
    public String renameDirectory(String newName){
        if(newName.equals("")) return "Provide a name!";
        
        this.name = newName;
        lastModified = LocalDateTime.now();
        return "Directory renamed to " + this.name;
    }
    
    private String addDirectory(Directory dir){
        if(isEmpty()) {
            Entry newDirectory = new Entry(dir);
            head = newDirectory;
            subDirectoryCount++;
            return "Added " + dir.getName() + " successfully\n";
        }
        
        Entry newDirectory = new Entry(dir);
        Entry current = this.head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        
        current.setNext(newDirectory);
        this.size++;
        subDirectoryCount++;
        lastModified = LocalDateTime.now();
        return "Added " + dir.getName() + " successfully\n";
    }
    
    public String removeDirectoryByName(String targetName){
        if(isEmpty()){
            return "Your directory is empty!\n";
        }
        
        String headName = head.isDirectory() ? 
                              head.getDirectory().getName()
                              : head.getFile().getName();
        if(head.getNext() == null && headName.equals(targetName) && head.isDirectory()) { //one element
            head = null;
            this.size--;
            lastModified = LocalDateTime.now();
            return "Removed directory successfully\n";
        }
        
        if(this.head.getNext() != null &&  headName.equals(targetName) && head.getNext().isDirectory()) {
            head = head.getNext();
            lastModified = LocalDateTime.now();
        }
        
        Entry current = head;
        Entry prev = null;
        
        while(current != null) {
            if(current.isDirectory()){
                String currentName = current.getDirectory().getName();
            
                if(currentName.equals(targetName)) {
                    if(currentName.equals("Home.finux")){
                        return "You cannot remove the root directory!\n";
                    }

                    subDirectoryCount--;

                    prev.setNext(current.getNext());
                    lastModified = LocalDateTime.now();
                    return "Removed directory successfully";
                }
            }
            
            prev = current;
            current = current.getNext();
            
        }
       
        return "Cannot remove directory!\n";
    }
    
    public String removeFileByName(String targetName){
        if(isEmpty()){
            return "Your directory is empty!\n";
        }

        String headName = head.isDirectory() ? 
                              head.getDirectory().getName()
                              : head.getFile().getName();
        
        if(headName.equals(targetName) && !head.isDirectory()) { //one element
            head = head.getNext();
            this.size--;
            lastModified = LocalDateTime.now();
            return "Removed " + targetName + " successfully\n";
        }

        Entry current = head;
        Entry prev = null;

        while(current != null) {
            
            if(!current.isDirectory()){
                String currentName = current.getFile().getName();

                if(currentName.equals(targetName)) {
                    fileCount--;

                    prev.setNext(current.getNext());
                    lastModified = LocalDateTime.now();
                    
                    return "Removed " + targetName + " successfullty\n";
                }
            }
            
            prev = current;
            current = current.getNext();

        }

        return "Cannot remove " + targetName + " from directory!\n";
    }

    
    public Directory getSubDirectory(String targetName) {
        if(isEmpty()){
//            System.out.println("Directory is Empty\n\n");
            return null;
        }
        
        Entry current = head;
        while(current != null) {
            if(current.isDirectory() && current.getDirectory().getName().equals(targetName)){
                return current.getDirectory();
            }
            current = current.getNext();
        }
        
        return null;
    }
    
    private File getFile(String targetName){
        if(isEmpty()){
//            System.out.println("Directory is Empty\n\n");
            return null;
        }
        
        
        
        Entry current = head;
        while(current != null) {
            if(!current.isDirectory() && current.getFile().getName().equals(targetName)){
                return current.getFile();
            }
            current = current.getNext();
        }
        
        return null;
    }
    
    public String listContents(){
        if(isEmpty()){
//            System.out.println("Directory is Empty!\n\n");
            return "";
        }
        
        String contents = "";
        
        Entry current = head;
        while(current != null) {
            boolean isDirectory = current.isDirectory();
            if(isDirectory)
                contents += "[DIR] " + current.getDirectory().getName() + "\t";
            else 
                contents += "[FILE] " + current.getFile().getName() + "\t";
            
            current = current.getNext();
        }
        
        contents += "\n";
        return contents;
    }
    
    public String listDirectories(){
        return listDirectories(head) + "\n";
       
    }
    
    private String listDirectories(Entry head){
        if(head == null) return "";
        
        if(head.isDirectory()){
            return "[DIR] " + head.getDirectory().getName() + "\t" + listDirectories(head.getNext());
        }
        
        return listDirectories(head.getNext());
    }
    
    public String listFiles(){
        return listFiles(head) + "\n";
     }
    
    private String listFiles(Entry head){
        if(head == null) return "";
        
        if(!head.isDirectory()){
            return "[FILE] " + head.getFile().getName() + "\t" + listFiles(head.getNext());
        }
        
        return listFiles(head.getNext());
    }
    
    public String  getDirectoryPath(String indent){
       return getDirectoryPath(this) + indent;
    }
    
    private boolean subDirectoryExists(String name){
        Directory sub = getSubDirectory(name);
        
        if(sub == null) {
            return false;
        } 
        
        return true;
    }
    
    private boolean fileExists(String name){
        File f = getFile(name);
        
        if(f == null) {
            return false;
        } 
        
        return true;
    }
    
    private String getDirectoryPath(Directory dir){
        if(dir == null) return "";
        
        
        return getDirectoryPath(dir.getParent()) + dir.getName() + "/ ";
    }
    
    
    private void entryCount(String type){
        if(type.equals("dir")){
            System.out.println("Directory count: " + getSubDirectoryCount());
            return;
        }

        System.out.println("File count: " + getFileCount() + "\n");
    }
 
    public String createDirectory(String dirName){
            if(dirName.equals("")){
                System.out.println("You cannot have an empty name, try again!");
                return "Make sure to provide a name!\n";
            }
            
            if(!subDirectoryExists(dirName)){
                Directory newSubDirectory = new Directory(dirName, this);
                addDirectory(newSubDirectory);
            } else {
                System.out.println("[DIR]" + dirName + " already exists!");
                return "[DIR] " + dirName + " already exists!\n";
            }
            
            return "Directory created successfully\n";
    }
    
    public String createFile(String fileName){
        if(fileName.equals("")){
           System.out.println("You cannot have an empty name, try again!");
           return "Make sure to provide a name!\n";
        }
        
         if(fileName.startsWith("-")){
            System.out.println("A file cannot start with a command dash!\n");
            return "A file cannot start with a command dash!\n";
        }
          
        if(!fileName.contains(".txt")){
            fileName += ".txt";
        }

        if(!fileExists(fileName)){
            File newFile = new File(fileName, null, this);
            addFile(newFile);
        } else {
            System.out.println(fileName + " already exists in this directory!");
            return "[FILE] " + fileName + " already exists in this directory\n";
        }
        
        return "[FILE] " + fileName + " created successfully\n";
    }
    
    public Directory navigateDirectory(String dirName, Navigation navigationStack, Directory root) throws Exception{
        //see if directory empty and if it exists
        if(dirName.equals("")){
            System.out.println("Cannot navigate to this directory, privide a name!\n");
            return navigationStack.peek();
        }
        
        if(dirName.equals("..")){
            if(navigationStack.peek() == root){
                System.out.println("Home.finux/ is the root directory!\n");
                return navigationStack.peek();
            } 
            
            navigationStack.popDirectory();
            return navigationStack.peek();
        }
           
        boolean dirExists = subDirectoryExists(dirName);
        Directory subDirectory = null;
        if(dirExists){
            //find the directory and display its menu
            subDirectory = getSubDirectory(dirName);
            navigationStack.pushDirectory(subDirectory);
        } else {
            
            if(this.size == 0){
                System.out.println("This directory is empty, you cannot navigate to anywhere!\n");
            }
            
            System.out.println("Directory doesn't exist!\n");
            return navigationStack.peek();
            
        }
        
        return navigationStack.peek();
    }
    
    public void openFile(String fileName){
        
        if(fileName.equals("")){
            System.out.println("Privide a file name!\n");
            return;
        }
        
        if(!fileName.contains(".txt"))
            fileName += ".txt";
        
        File openedFile = getFile(fileName);
        if(openedFile == null){
            System.out.println("This file doesn't exist in this directory!\n");
            return;
        }
        
        openFileGUI(openedFile);        
    }
    
    private void openFileGUI(File file){
        JFrame frame = new JFrame("Edit File: " + file.getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null); // Center the window

        // Create a JTextArea for content editing
        JTextArea textArea = new JTextArea();
        textArea.setText(file.getContent()); // Load existing content if any
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create a Save button
        JButton saveButton = new JButton("Save");
        frame.add(saveButton, BorderLayout.SOUTH);

        // Add action listener to Save button
        saveButton.addActionListener(e -> {
            String content = textArea.getText();
            file.setContent(content); 
            JOptionPane.showMessageDialog(frame, "File saved successfully.");
            frame.dispose();
        });

        
        frame.setVisible(true);
    }
    
    public String createManyFiles(String command, Queue taskQueue){
        try {
            //get file names after touch
        
            if(!command.substring(8).startsWith(" ")){
                System.out.println("Invalid command!\n");
                return "Invalid command\n";
            }

            String []words = command.substring(9).split(" ");

            //Add files to the queue (with .txt)
            for(int i = 0; i < words.length; i++){
                if(!words[i].contains(".txt"))
                    words[i] += ".txt";

                taskQueue.Enqueue(words[i]);
            }        

            while(!taskQueue.isEmpty()){
                createFile(taskQueue.Dequeue());
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        
        return "Created files successfully\n";
        
    }
    
    public String removeManyFiles(String command, Queue taskQueue){
        LinkedList<String> warningList = new LinkedList<>();
        int removedFiles = 0;
        
        try {
            if(!command.substring(6).startsWith(" ")){
                System.out.println("Invalid command!\n");
                return "Invalid command!\n";
            }

            String []words = command.substring(7).split(" ");

            //Add files to the queue (with .txt)
            for(int i = 0; i < words.length; i++){
                if(!words[i].contains(".txt"))
                    words[i] += ".txt";

                taskQueue.Enqueue(words[i]);
            } 

            while(!taskQueue.isEmpty()){
                File findFile = getFile(taskQueue.getFrontElement());
                if(findFile == null){
                    String message = taskQueue.Dequeue() + " doesnt exist!\n";
                    warningList.add(message);
                }else {
                    removedFiles++;
                    removeFileByName(taskQueue.Dequeue());
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        
        if(!warningList.isEmpty()){
            String getWarnings = "";
            
            if(removedFiles > 0){
                getWarnings += ("Removed " + removedFiles + " files, but: \n");
            }
            
            for(int i = 0; i < warningList.size(); i++)
                getWarnings += warningList.get(i);
            
            return getWarnings;
        }
        
        return "Removed " + removedFiles + " files successfully\n";
    }
    
    public String help(){
        StringBuilder helpMessage = new StringBuilder();

        helpMessage.append("\n");
        helpMessage.append("dc - Get Directory Count\n");
        helpMessage.append("fc - Get File Count\n");
        helpMessage.append("touch - Create file\n");
        helpMessage.append("touch many - Create many files\n");
        helpMessage.append("mkdir - Create directory\n");
        helpMessage.append("rmv -f - Delete file by name\n");
        helpMessage.append("rmv -d - Delete directory by name\n");
        helpMessage.append("path - Get directory path\n");
        helpMessage.append("cd - Navigate to another directory\n");
        helpMessage.append("open - Open a file\n");
        helpMessage.append("ls - List contents\n");
        helpMessage.append("ls -D - List directories only\n");
        helpMessage.append("ls -F - List files only\n");
        helpMessage.append("exit - Exit from command line\n");

        return helpMessage.toString();
    }


    
}