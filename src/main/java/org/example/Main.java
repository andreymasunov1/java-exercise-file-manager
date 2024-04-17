package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("Please choose a mode! 1: create file, 2: read file, 3: write into file, 4: delete file ");
        System.out.print(" > ");
        String mode = in.nextLine();

        System.out.println("Please enter a filename (with full path)!");
        System.out.print(" > ");
        String filename = in.nextLine();

        Path path = Paths.get(filename);

        switch (mode) {
            case "1": MyFile.createMyFile(path);
            break;
            case "2": MyFile.readMyFile(path);
            break;
            case "3":
                System.out.println("Please enter what you want to write to file");
                System.out.print(" > ");
                String stringForFile = in.nextLine();
                MyFile.writeIntoMyFile(path, stringForFile);
            break;
            case "4": MyFile.deleteMyFile(path);
        }

        System.out.printf("finished with mode: " +mode + ": " + filename);
    }

}