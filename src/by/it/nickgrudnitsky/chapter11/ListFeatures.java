package by.it.nickgrudnitsky.chapter11;//: holding/ListFeatures.java

import by.it.nickgrudnitsky.typeinfo.pets.*;


import java.util.*;

import static by.it.nickgrudnitsky.myLibrary.Print.print;


public class ListFeatures {
  public static void main(String[] args) {
    Random rand = new Random();
    List<Integer> pets = ListOfRandomIntegers(5);
    print("1: " + pets);
    pets.add(6); // Automatically resizes
    print("2: " + pets);
    print("3: " + pets.contains(6));

    Integer p = pets.get(2);
    print("4: " +  p + " " + pets.indexOf(p));
    Pet cymric = new Cymric();
    print("5: " + pets.indexOf(3));
    print("6: " + pets.remove(((Integer)3)));
    // Must be the exact object:
    print("7: " + pets.remove(p));
    print("8: " + pets);
    pets.add(3, 7); // Insert at an index
    print("9: " + pets);
    List<Integer> sub = pets.subList(1, 4);
    print("subList: " + sub);
    print("10: " + pets.containsAll(sub));
    Collections.sort(sub); // In-place sort
    print("sorted subList: " + sub);
    // Order is not important in containsAll():
    print("11: " + pets.containsAll(sub));
    Collections.shuffle(sub, rand); // Mix it up
    print("shuffled subList: " + sub);
    print("12: " + pets.containsAll(sub));
    List<Integer> copy = new ArrayList<Integer>(pets);
    sub = Arrays.asList(pets.get(1), pets.get(4));
    print("sub: " + sub);
    copy.retainAll(sub);
    print("13: " + copy);
    copy = new ArrayList<Integer>(pets); // Get a fresh copy
    copy.remove(2); // Remove by index
    print("14: " + copy);
    copy.removeAll(sub); // Only removes exact objects
    print("15: " + copy);
    copy.set(1, 8); // Replace an element
    print("16: " + copy);
    copy.addAll(2, sub); // Insert a list in the middle
    print("17: " + copy);
    print("18: " + pets.isEmpty());
    pets.clear(); // Remove all elements
    print("19: " + pets);
    print("20: " + pets.isEmpty());
    pets.addAll(Arrays.asList(10,11,12));
    print("21: " + pets);
    Object[] o = pets.toArray();
    print("22: " + o[1]);
    Pet[] pa = pets.toArray(new Pet[0]);
    print("23: " + pa[0].id());
  }

  public static List<Integer> ListOfRandomIntegers (int length){
    Random rand = new Random();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      list.add(rand.nextInt());
    }
    return list;
  }
} /* Output:
1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
2: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]
3: true
4: Cymric 2
5: -1
6: false
7: true
8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
subList: [Manx, Mutt, Mouse]
10: true
sorted subList: [Manx, Mouse, Mutt]
11: true
shuffled subList: [Mouse, Manx, Mutt]
12: true
sub: [Mouse, Pug]
13: [Mouse, Pug]
14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]
15: [Rat, Mutt, Cymric, Pug]
16: [Rat, Mouse, Cymric, Pug]
17: [Rat, Mouse, Mouse, Pug, Cymric, Pug]
18: false
19: []
20: true
21: [Manx, Cymric, Rat, EgyptianMau]
22: EgyptianMau
23: 14
*///:~
