package by.it.nickgrudnitsky.chapter12.tasks14and15;

public class OnOffSwitch {
    private static Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2 {

    }

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            throw new RuntimeException();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}
