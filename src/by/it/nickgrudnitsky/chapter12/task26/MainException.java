package by.it.nickgrudnitsky.chapter12.task26;

import java.io.FileInputStream;

public class MainException {

  public static void main(String[] args) throws Exception {

    FileInputStream file =
      new FileInputStream("MainException.java");

    file.close();
  }
}