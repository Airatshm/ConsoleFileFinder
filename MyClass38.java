package myclass38;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class MyClass38 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Press enter to continue...");
//        scanner.nextLine();
        JFileChooser fileChooser = new MyFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        String[] nameParts = file.getName().split("\\.");
        String ext = nameParts[nameParts.length - 1];

        FileOpener opener;
        if (ext.equals("txt") || ext.equals("log")) {
            opener = new TextFileOpener(file);
            executeFile(opener);
        } else if (ext.equals("mp3") || ext.equals("mp4") || ext.equals("m4a")) {
            opener = new MediaFileOpener(file);
            executeFile(opener);
        } else {
            opener = new FileOpener(file);
            executeFile(opener);
        }
    }

    public static void executeFile(FileOpener opener) {
        opener.printFileInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to open file? (y/n)");
        String answer = scanner.next();
        if (answer.equals("y")) {
            opener.openFile();
        } else {
            System.out.println("Program will terminate");
        }
    }
}
