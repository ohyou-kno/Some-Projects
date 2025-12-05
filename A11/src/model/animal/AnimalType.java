package model.animal;

import java.io.Serializable;

public class AnimalType implements Serializable {
    // instance variables
    private String type;
    private AnimalCategory category;
    private String emoji;
    private boolean isReal;
    private boolean takesWalks;

    private String sound;
//constructor
    public AnimalType(String type, AnimalCategory category, String emoji, boolean isPet, String sound, boolean walkable) {
        this.type = type;
        this.category = category;
        this.emoji = emoji;
        this.isReal = isPet;
        this.sound = sound;
        takesWalks = walkable;
    }
// getters for whether it takes walks, the type of animal, sound the animal makes, the category the animal is in
// the emoji that represents it, and whether the animal is real
    // only for WalkablePet objects
    public boolean takesWalks() {
        return takesWalks;
    }

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }

    public AnimalCategory getCategory() {
        return category;
    }

    public String getEmoji() {
        return emoji;
    }
// returns true if the animal is a Pet object, false if it's an AnimalBot object
    public boolean isReal() {
        return isReal;
    }

// equals, hashcode, and toString overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalType that = (AnimalType) o;
            return isReal != that.isReal
             && type.equals(that.type)
                    && category != that.category
                    &&  emoji.equals(that.emoji)
                    && sound.equals(that.sound);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + emoji.hashCode();
        result = 31 * result + (isReal ? 1 : 0);
        result = 31 * result + sound.hashCode();
        return result;
    }
// ex. 🐢 Turtle (aquatic)
    @Override
    public String toString() {
        return  emoji + " " + type +  " ( " + category + ") " ;
    }
}