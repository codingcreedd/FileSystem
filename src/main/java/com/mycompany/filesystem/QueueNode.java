package com.mycompany.filesystem;

public class QueueNode {
    String entryName;
    QueueNode next;
    
    public QueueNode(String entryName){
        this.entryName = entryName;
        next = null;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
    
    
    
}
