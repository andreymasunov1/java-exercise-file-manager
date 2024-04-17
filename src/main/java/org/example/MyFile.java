package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MyFile {

  public static void createMyFile(Path path) {
    try {
      Path newFilePath = Paths.get(path.toUri());
      Files.createFile(newFilePath);
    } catch (FileAlreadyExistsException e) {
      System.out.println("File already exists!");
    } catch (AccessDeniedException e) {
      System.out.printf("You do not have permission to use path: %s\n", path);
    } catch (IOException e) {
      System.out.println("Please enter valid file path");
    }
  }

  public static void readMyFile(Path path) {
    Path filePath = Paths.get(path.toUri());
    BufferedReader reader;
      try {
        reader = Files.newBufferedReader(filePath);
        if (reader.ready()) {
          System.out.println(reader.readLine());
        }
      } catch (SecurityException e) {
        System.out.println("You do not have permission to use path: %s");
      } catch (IOException e) {
        System.out.println("There is an issue while reading the file");
      }
  }

  public static void writeIntoMyFile(Path path, String stringForFile) {
    try {
      Files.write(
          Paths.get(path.toUri()),
          stringForFile.getBytes(),
          StandardOpenOption.APPEND);
    } catch (SecurityException e) {
      System.out.println("You do not have permission to use path: %s");
    } catch (IOException e) {
      System.out.println("There is an issue while writing the file");
    }
  }

  public static void deleteMyFile(Path path) {
    try {
      if (Files.deleteIfExists(path)) {
        System.out.println("File deleted!");
      }
    } catch (SecurityException e) {
      System.out.println("You do not have permission to use path: %s");
    } catch (IOException e) {
      System.out.println("There is an issue while deleting the file");
    }
  }
}