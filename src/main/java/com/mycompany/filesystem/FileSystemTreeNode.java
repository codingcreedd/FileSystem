package com.mycompany.filesystem;

import javax.swing.tree.DefaultMutableTreeNode;

public class FileSystemTreeNode extends DefaultMutableTreeNode {
    private boolean isDirectory;
    
    public FileSystemTreeNode(String name, boolean isDirectory){
        super(name);
        this.isDirectory = isDirectory;
    }
    
    @Override
    public boolean isLeaf(){
        return !isDirectory;
    }
    
    public boolean isDirectory(){
        return isDirectory;
    }
}
