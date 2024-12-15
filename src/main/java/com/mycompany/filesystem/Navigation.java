/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filesystem;

public class Navigation {
    NavigationNode top;
    int size;
    
    public Navigation(){
        top = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public void pushDirectory(Directory dir){
        NavigationNode newNode = new NavigationNode(dir);
        if(isEmpty()){
            top = newNode;
            return;
        }
        
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    
    public Directory peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Empty Stack\n\n");
        }
        
        return top.getDir();
    }
    
    public Directory popDirectory() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty Stack\n\n");
        }
        
        Directory popped = top.getDir();
        top = top.getNext();
        size--;
        return popped;
    }
    
    public int getSize(){
        return size;
    }
}
