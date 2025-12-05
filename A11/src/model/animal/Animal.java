package model.animal;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    private final AnimalType type;
    private final String name;
    private int happiness;
    private int age;

    public Animal(AnimalType type, String name, int happiness, int age) {
        this.type = type;
        this.name = name;
        this.happiness = happiness;
        this.age = age;
    }
    public Animal(Animal a) {
        this(a.type, a.name, a.happiness, a.age);
    }

    public Animal(AnimalType type, String name){
        this(type, name, (int) (Math.random() * 100 + 1), 0); // Random happiness between 1 and 100
    }

    public AnimalType getType() {
        return type;
    }


    public String getName() {
        return name;
    }

    public String getFullName() {
        return name + " the " + type.getType() + " " + type.getEmoji();

    }
    public void growOlder(){
        age++;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void increaseHappiness(int amount) {
        happiness = Math.min(100, happiness + amount); // Ensure happiness does not exceed 100
    }

    public void decreaseHappiness(int amount) {
        happiness = Math.max(0, happiness - amount); // Ensure happiness does not go below 0
    }
    public String play(){
        increaseHappiness((int) (Math.random() * 5 ) +1);
        return this.name + " is so happy you decided to play with them!";// Random happiness added between 1-5
    }

    public abstract String makeSound();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;
        return happiness == animal.happiness
                && age == animal.age
                && type == animal.type
                && name.equalsIgnoreCase(animal.name);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + name.toLowerCase().hashCode(); //update to lower
        result = 31 * result + happiness;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getFullName();

    }

    public String getAllData() {
        return toString() + " age: " + this.age + ", happiness: " +  this.happiness + ", category: " + this.getType().getCategory();
    }
}
