package collections.entity;

public class Dog implements Comparable<Dog> {
    private String name;
    private int age;
    private int weight;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Dog o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return this.name + "/" + this.age + "y/" + this.weight + "kg ";
    }
}
