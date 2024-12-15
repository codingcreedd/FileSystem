package com.mycompany.filesystem;

public class Entry {
    private boolean isDirectory;
    private Directory directory;
    private File file;
    
    private Entry next;
    
    public Entry(File file) { //file entry
        this.file = file;
        this.isDirectory = false;
        this.directory = null;
        this.next = null;
    }
    
    public Entry(Directory directory){
        this.directory = directory;
        this.isDirectory = true;
        this.file = null;
        this.next = null;
    }
    
    public boolean isDirectory(){
        return isDirectory;
    }
    
    public Directory getDirectory(){
        return directory;
    }
    
    public File getFile(){
        return file;
    }
    
    public Entry getNext(){
        return next;
    }
    
    public void setNext(Entry next){
        this.next = next;
    }
}
