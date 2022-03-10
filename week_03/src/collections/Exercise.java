package collections;

import collections.entity.Dog;

import java.util.*;

public class Exercise {
    // Task 1
    public static void addElements() {
        List<String> elements = new ArrayList<>();
        elements.add("first");
        elements.add(0, "second");
        elements.add("third");
        elements.forEach(System.out::println);
    }

    // Task 2
    public static void getElement() {
        List<String> elements = new ArrayList<>();
        elements.add("first");
        elements.add(0, "second");
        elements.add("third");
        System.out.println(elements);
        String s = elements.get(1);
        System.out.println(s);
    }

    // Task 3
    public static void removeElement(List<String> elements, int index) {
        elements.remove(index);
    }

    // Task 4

    public static void main(String[] args) {
        getElement();

        Dog dog1 = new Dog("gosho", 22, 45);
        Dog dog2 = new Dog("pesho", 12, 67);
        Dog dog3 = new Dog("mitko", 5, 21);
        System.out.println(dog1.compareTo(dog2));

        // ku4eta
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

        // sorting a list using compareTo
        Collections.sort(dogs);
        System.out.println("By weight: " + dogs);

        // using comparator
        Collections.sort(dogs, new AgeComparator());
        System.out.println("By age: " + dogs);
    }
}
