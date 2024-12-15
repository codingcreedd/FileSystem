/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filesystem;

public class Commands {
    
    public static String getNameFromCommand(String command){
        //Get the second word in 'command'
        String[] words = command.split("\\s+"); 
        
        if(words.length >= 2){
            for(int i = 1; i < words.length; i++){
                if(words[i].startsWith("-")) continue;
                else return words[i];
            }
        } 
       
        return "";
    }
    
    public static void main(String[] args) {
        
    }
}
