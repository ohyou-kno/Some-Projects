package model.animal;

public class Pet extends Animal {
    private int hungerLevel; // must be 0-10
    private String sound;

    public Pet(AnimalType typeName, String name, int happiness, int age, int hungerLevel) {
        super(typeName, name, happiness, age);
        setPetVariables(hungerLevel);
    }
    public Pet(Animal a, int hungerLevel) {
        super(a); //copy constructor
        setPetVariables(hungerLevel);
    }
    public Pet(Animal a) {
        this(a,  (int) (Math.random() * 11 ));
    }
    public Pet(AnimalType typeName, String name) {
        super(typeName, name);
        setPetVariables();
    }

    private void setPetVariables(){
        setPetVariables((int) (Math.random() * 11 ));
    }
    private void setPetVariables(int hungerLevel) {
        setHungerLevel(hungerLevel);
        this.sound = getType().getSound();
    }

    // happiness goes down if pet is fed and not hungry...
    public String feed(String foodType)  {
        String message = this.getFullName() + " \" says:\" ";

        HungerLevel level = HungerLevel.getHungerLevel(this.hungerLevel);
        if(level == HungerLevel.HUNGRY) {
            increaseHappiness((int) (Math.random() * 5 ) +1);
            message += " I was hungry, getting " + foodType + " made me happy. Happiness level is now: " + getHappiness();
        }
        else if(level == HungerLevel.OKAY){
            message += " I wasn't actually hungry, but thanks for the " + foodType;
        }
        else if(level == HungerLevel.FULL){// full
            decreaseHappiness((int) (Math.random() * 5 ) +1);
            message += " I was already full, giving me " + foodType + " made me feel sick. Happiness level is now: " + getHappiness();
        }
        else{
            message = this.getFullName() + " rejected the food because they had an UNKNOWN hunger level";
        }
        return message;
    }
    public void setHungerLevel(int hungerLevel) {
        if(hungerLevel < 0){
            this.hungerLevel = 0;
        }
        else if (hungerLevel > 10){
            this.hungerLevel = 10;
        }
        else {
            this.hungerLevel = hungerLevel;
        }
    }

    public int getHungerNumber() {
        return hungerLevel;
    }

    public String getHungerMessage(){
        String message = HungerLevel.getHungerLevel(hungerLevel).getMessage() + " for hungerLevel of " + hungerLevel;
        return message;
    }

    @Override
    public String makeSound() {
        return getFullName() + " says: " + sound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pet pet = (Pet) o;
        return hungerLevel == pet.hungerLevel &&  sound.equals(pet.sound);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + hungerLevel;
        result = 31 * result + sound.hashCode();
        return result;
    }
    public String getAllData() {
        return super.getAllData() + ", hunger: " + hungerLevel + "(Level: " + HungerLevel.getHungerLevel(hungerLevel) + ")";
    }
}
