# **FileSystem Project**

A Java-based **File System Simulation** with both a **Command-Line Interface (CLI)** and a **Graphical User Interface (GUI)** using **JFrame**.  
The project implements **Object-Oriented Programming (OOP)** concepts and several **data structures**:  
- **Arrays**  
- **Linked Lists**  
- **Stacks**  
- **Queues**  
- **Trees** (specifically **AVL Trees**).  

---

## **📋 Table of Contents**
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Project Structure](#project-structure)
4. [How to Run](#how-to-run)
5. [Supported Commands](#supported-commands)

---

## **🚀 Features**
- **Command-Line Interface (CLI):**  
   - Mimics a terminal for interacting with the file system.  
   - Supports creating, navigating, and deleting files and directories.

- **Graphical User Interface (GUI):**  
   - Built using **Swing (JFrame)** for dynamic rendering of the file system structure.  
   - Displays the current path, command input, and output in an intuitive layout.

- **Data Structures Implementation:**  
   - **Linked Lists**: Manages directory entries (files and subdirectories).  
   - **Stacks**: Tracks navigation paths (`cd` command).  
   - **Queues**: Handles batch file operations (e.g., creating or deleting multiple files).  
   - **AVL Trees**: Organizes and balances file system entries for efficient searching.

- **Object-Oriented Design:**  
   - Modularized classes for directories, files, navigation, and commands.

---

## **🛠️ Technologies Used**

- **Programming Language**: Java  
- **IDE**: NetBeans 23  
- **GUI Library**: Swing (JFrame, JPanel, JTextArea, JTextField, etc.)  
- **Version Control**: Git and GitHub  

---

## **📂 Project Structure**

```plaintext
FileSystem/
│
├── src/
│   ├── com.mycompany.filesystem/
│   │   ├── FileSystem.java         # Main class to run the program
│   │   ├── Directory.java          # Directory class with linked list implementation
│   │   ├── File.java               # File class
│   │   ├── Entry.java              # Node class for directory/file entries
│   │   ├── Navigation.java         # Stack implementation for navigation
│   │   ├── Queue.java              # Queue implementation for batch operations
│   │   ├── Commands.java           # Helper methods for command parsing
│   │   ├── FileSystemGUI.java      # GUI implementation using JFrame
│
├── README.md                       # Project documentation
└── .gitignore                      # Git ignore file
```

## **🖥️ Supported Commands
Command	Description
- **mkdir <name>**	Create a new directory.
- **cd <directory>**	Change to a specified directory.
- **touch <file>**	Create a new file.
- **touch -m <files>**	Create multiple files.
- **ls**	List contents of the current folder.
- **ls -d**	List directories only.
- **ls -f**	List files only.
- **rmv -f <file>**	Remove a specified file.
- **rmv -d <directory>**	Remove a specified directory.
- **rmv -m <files>** Remove many files
- **path**	Display the current directory path.
- **exit**	Exit the program.
