package by.it.nickgrudnitsky.chapter14.coffee;

import by.it.nickgrudnitsky.myLibrary.Generator;
import by.it.nickgrudnitsky.myLibrary.TypeCounter;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator
        implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class,};
    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    private int size = 0;

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    public Coffee next() {
        try {
            return (Coffee)
                    types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    ;

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        TypeCounter counter = new TypeCounter(Coffee.class);
        for (int i = 0; i < 5; i++){
            Coffee next = gen.next();
            System.out.println(next);
            counter.count(next);
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
            counter.count(c);
        }

        System.out.println(counter);
    }
}
