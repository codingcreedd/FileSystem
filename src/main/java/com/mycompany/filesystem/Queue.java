package com.mycompany.filesystem;

public class Queue {
    private QueueNode front; //dequeue from here
    private QueueNode rear; //enqueue from here
    private int size;
    
    public Queue(){
        front = null;
        rear = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return front == null;
    }
    
    public void Enqueue(String entryName){
        QueueNode newNode = new QueueNode(entryName);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
            size++;
            return;
        }
        
        rear.setNext(newNode);
        rear = newNode;
        size++;
    }
    
    public String getFrontElement(){
        if(isEmpty()){
            return "Queue is empty!\n";
        }
        
        return front.getEntryName();
    }
    
    public String Dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Task queue is empty!\n");
        }
        
        String entryName = front.getEntryName();
        if(front == rear){ //one entry only
            front = null;
            rear = null;
            size--;
            return entryName;
        }
       
        front = front.getNext();
        size--;
        return entryName;
    }
    
    public int getSize(){
        return size;
    }
    
}
