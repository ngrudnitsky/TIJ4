package by.it.nickgrudnitsky.chapter13;

import java.io.PrintStream;
import java.util.Formatter;

public class Task3 {
  private String name;
  private Formatter f;
  public Task3(String name, Formatter f) {
    this.name = name;
    this.f = f;
  }
  public void move(int x, int y) {
    f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
  }
  public static void main(String[] args) {
    PrintStream outAlias = System.err;
    Task3 tommy = new Task3("Tommy",
      new Formatter(System.err));
    Task3 terry = new Task3("Terry",
      new Formatter(outAlias));
    tommy.move(0,0);
    terry.move(4,8);
    tommy.move(3,4);
    terry.move(2,5);
    tommy.move(3,3);
    terry.move(3,3);
  }
}