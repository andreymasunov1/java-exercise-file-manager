package org.example;

import static org.example.MyFile.createMyFile;
import static org.example.MyFile.deleteMyFile;
import static org.example.MyFile.readMyFile;
import static org.example.MyFile.writeIntoMyFile;

import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String mode = getString(
                "Please choose a mode! 1: create file, 2: read file, 3: write into file, 4: delete file, 5: exit",
                in);

            switch (mode) {
                case "1":
                    createMyFile(Paths.get(getFilePath(in)));
                    break;
                case "2":
                    readMyFile(Paths.get(getFilePath(in)));
                    break;
                case "3":
                    writeIntoMyFile(Paths.get(getFilePath(in)), getString("Please enter a string for write into file", in));
                    break;
                case "4":
                    deleteMyFile(Paths.get(getFilePath(in)));
                    break;
                case "5":
                    System.out.println("Exiting...");
                    return;
              default:
                  System.out.println("Invalid mode! Try again!");
            }
        }
    }

    private static String getFilePath(Scanner in) {
        System.out.println("Please enter a filename (with full path)!");
        System.out.print(" > ");
        return in.nextLine();
    }

    private static String getString(String textForCustomer, Scanner in){
        System.out.println(textForCustomer);
        return in.nextLine();
    }

}