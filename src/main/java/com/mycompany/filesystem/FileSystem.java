package com.mycompany.filesystem;
import java.util.Scanner;
import javax.swing.JFrame;

public class FileSystem {

    public static void clearScreen() {  
        for(int clear = 0; clear < 100; clear++)
        {
             System.out.println("\b") ;
        }  
    }  
    
    public static Directory evaluateCMDConsole(String command, Directory root, Directory currentDirectory, Queue taskQueue, Navigation navigationStack){
        try{
            if (command.equals("exit"))
                    System.out.println();

                else if (command.equals("dc")) 
                    System.out.println(currentDirectory.getSubDirectoryCount());

                else if (command.equals("fc")) 
                    System.out.println(currentDirectory.getFileCount());

                else if (command.startsWith("mkdir")) 
                    currentDirectory.createDirectory(Commands.getNameFromCommand(command));
                
                else if(command.startsWith("touch -m")) {
                    currentDirectory.createManyFiles(command, taskQueue);
                }
                else if (command.startsWith("touch")) 
                    currentDirectory.createFile(Commands.getNameFromCommand(command));

                else if (command.equals("path")) 
                    System.out.print(currentDirectory.getDirectoryPath("\n\n"));

                else if (command.startsWith("cd")){
                    currentDirectory = currentDirectory.navigateDirectory(Commands.getNameFromCommand(command), navigationStack, root);
                }
                else if (command.equals("ls")) 
                    System.out.print(currentDirectory.listContents());

                else if(command.equals("-h"))
                    System.out.println(currentDirectory.help());

                else if(command.equals("ls -D") || command.equals("ls -d"))
                    System.out.println(currentDirectory.listDirectories());

                else if(command.equals("ls -F") || command.equals("ls -f"))
                    System.out.println(currentDirectory.listFiles());
                
                else if(command.startsWith("open"))
                    currentDirectory.openFile(Commands.getNameFromCommand(command));
                
                else if(command.startsWith("rmv -m"))
                    currentDirectory.removeManyFiles(command, taskQueue);
                
                
                else if(command.startsWith("rmv")){
                    String commandString = Commands.getNameFromCommand(command);
                    if(command.contains("-f") || command.contains("-F")){
                        commandString += ".txt";
                        currentDirectory.removeFileByName(commandString);
                    }
                 
                    if(command.contains("-d") || command.contains("-D"))
                        currentDirectory.removeDirectoryByName(commandString);
                } 
                else {
                    System.out.println("Invalid command\nHere are the list of commands you can use: \n");
                    currentDirectory.help();
                }
            
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return currentDirectory;
    }
    
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        try {    
            Directory root = new Directory("Home.finux");
        
            Navigation navigationStack = new Navigation();
            navigationStack.pushDirectory(root);
            
            Queue taskQueue = new Queue();

            Directory currentDirectory = navigationStack.peek();
            
            JFrame frame = new JFrame("File System GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1170,758);
            
            FileSystemGUI fileSystemPanel = new FileSystemGUI(root, currentDirectory, navigationStack, taskQueue);
            frame.setContentPane(fileSystemPanel); 
            
            frame.setVisible(true); 

            String command = "";
            System.out.println("\n");
            do {
                System.out.print(currentDirectory.getDirectoryPath(""));
                command = in.nextLine().trim();

                currentDirectory = evaluateCMDConsole(command, root, currentDirectory, taskQueue, navigationStack);

            } while (!command.equals("exit"));
        } catch(Exception e) {
            System.out.println(e);
        }

        
    }
}
