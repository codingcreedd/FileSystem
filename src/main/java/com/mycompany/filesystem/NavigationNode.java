
package com.mycompany.filesystem;

public class NavigationNode {
    Directory dir;
    NavigationNode next;
    
    public NavigationNode(Directory dir){
        this.dir = dir;
        next = null;
    }

    public Directory getDir() {
        return dir;
    }

    public void setDir(Directory dir) {
        this.dir = dir;
    }

    public NavigationNode getNext() {
        return next;
    }

    public void setNext(NavigationNode next) {
        this.next = next;
    }
}
