package model.animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalBot extends Animal {

    //TODO: add at least 2 more messages to start
    private List<String> messages = new ArrayList<>(List.of(
            "Hello! It's great to see you! I'm so happy!",
            "Yay! You are here! I love spending time with you!",
            "Hey there! You're my favorite human!"));

    public void newMessages(){
        messages.add("你好！好高兴看看你！");
        messages.add("Bonjour! J'suis tres heureux de te voir!");
    }

    public AnimalBot(AnimalType typeName, String emoji, String name, int happiness, int age) {
        super(typeName, name, happiness, age);
    }

    public AnimalBot(Animal a) {
        super(a);
    }

    public AnimalBot(AnimalType typeName, String name) {
        super(typeName, name);
    }

    public void addMessage(String message) {
        messages.add(message);
    }
    public void addMessage(String... newMessages) {
        for(String s: newMessages) {
            messages.add(s);
        }
    }

    @Override
    public String makeSound() {
        return messages.get((int) (Math.random() * messages.size()));
    }

}
