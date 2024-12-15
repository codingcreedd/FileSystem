FileSystem Project

A Java-based File System project with a Graphical User Interface (GUI) created using JFrame in NetBeans 23. This project implements key concepts of Object-Oriented Programming (OOP) and utilizes various data structures, including:

    Arrays
    Linked Lists
    Stacks
    Queues
    Trees (specifically AVL Trees)

🔧 Features

    Command-Line Interface (CLI):
        Mimics a file system's command prompt.
        Supports commands like mkdir, cd, ls, touch, rmv, and more.
    Graphical User Interface (GUI):
        Displays the current file system structure dynamically.
        Provides input fields and output areas for easy interaction.
    Data Structures:
        Linked Lists for managing file and directory entries.
        Stacks for tracking navigation paths.
        Queues for task-based file creation/deletion.
        AVL Trees for efficient file/directory lookup and organization.
    Object-Oriented Design:
        Classes such as FileSystem, Directory, File, Entry, Navigation, and Commands encapsulate logic cleanly.

🖥️ Technologies Used

    Programming Language: Java
    IDE: NetBeans 23
    GUI: Swing (JFrame, JPanel, JTextArea, JTextField, JTree, etc.)

📂 Project Structure

FileSystem/
│
├── src/
│   ├── com.mycompany.filesystem/
│   │   ├── FileSystem.java         # Main class to start the program
│   │   ├── Directory.java          # Directory class with linked list implementation
│   │   ├── File.java               # File class
│   │   ├── Navigation.java         # Stack implementation for navigation
│   │   ├── Queue.java              # Queue implementation for tasks
│   │   ├── Entry.java              # Linked list node for directory/file entries
│   │   ├── Commands.java           # Helper for parsing commands
│   │   ├── FileSystemGUI.java      # JFrame GUI implementation
│
├── README.md                       # Project description
└── .gitignore                      # Git ignore file

🚀 How to Run the Project

    Clone the repository:

    git clone https://github.com/username/repository.git
    cd repository

    Open the project in NetBeans 23.
    Build and run the project.
    The GUI will open, allowing you to interact with the file system.

📝 Commands Supported

The project supports the following commands:
Command	Description
mkdir <name>	Create a new directory.
cd <directory>	Change to a specified directory.
touch <file>	Create a new file.
touch -m <files> Create many files
ls	List contents of the current folder.
rmv -f <file>	Remove a specified file.
rmv -m <files> Remove many files
rmv -d <directory>	Remove a specified directory.
path	Display the current directory path.
exit	Exit the program.


🤝 Contributing

Contributions are welcome! Feel free to fork the repository and submit a pull request.
