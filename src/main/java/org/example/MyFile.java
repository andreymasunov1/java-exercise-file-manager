package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MyFile {

  static void createMyFile(Path path) {
    try {
      Path newFilePath = Paths.get(path.toUri());
      Files.createFile(newFilePath);
    } catch (IOException e) {
      System.out.println("Please enter valid file path");
    }
  }

  public static void readMyFile(Path path) {
    Path filePath = Paths.get(path.toUri());
    BufferedReader reader;
    String line = "";
      try {git remote add origin git@github.com:andreymasunov1/java-exercise-file-manager.git
        reader = Files.newBufferedReader(filePath);
        if (reader.ready()) {
          line = reader.readLine();
        }
      } catch (IOException e) {
        System.out.println("There is an issue while reading the file");
      }
    System.out.printf(line);
  }

  public static void writeIntoMyFile(Path path, String stringForFile) {
    try {
      Files.write(
          Paths.get(path.toUri()),
          stringForFile.getBytes(),
          StandardOpenOption.APPEND);
    } catch (IOException e) {
      System.out.println("There is an issue while writing the file");
    }
  }

  public static void deleteMyFile(Path path) {
    try {
      Files.deleteIfExists(path);
    } catch (IOException e) {
      System.out.printf("There is an issue while deleting the file");
    }
  }
}