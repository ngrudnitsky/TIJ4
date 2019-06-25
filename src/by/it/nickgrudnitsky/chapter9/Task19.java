package by.it.nickgrudnitsky.chapter9;


import java.util.Random;

public class Task19 {
    private static void rollSmt(RollFactory factory) {
        Roll roll = factory.getRoll();
        roll.toRoll();
    }
    public static void main(String[] args) {
        rollSmt(new CoinFactory());
        rollSmt(new DiceFactory());
    }
}

interface Roll {
    void toRoll();
}

interface RollFactory {
    Roll getRoll();
}

class Coin implements Roll {
    @Override
    public void toRoll() {
        Random random = new Random();
        if (random.nextInt(2) + 1 == 1) {
            System.out.println("Heads");
        } else {
            System.out.println("Tails");
        }
    }
}

class Dice implements Roll {
    @Override
    public void toRoll() {
        Random random = new Random();
        System.out.println("You roll " + (random.nextInt(6)+1));
    }
}

class CoinFactory implements RollFactory {
    @Override
    public Roll getRoll() {
        return new Coin();
    }
}

class DiceFactory implements RollFactory {
    @Override
    public Roll getRoll() {
        return new Dice();
    }
}
