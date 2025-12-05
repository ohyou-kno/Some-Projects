package model.animal;

import model.Walkable;

/**
 * TODO: Class description
 *
 * @author Kendra Walther
 * email: kwalther@usc.edu
 * ITP 265, Spring 2025, Coffee/Tea Section
 * Date created: 4/12/25
 */
public class WalkablePet extends Pet implements Walkable {

    public WalkablePet(AnimalType typeName, String name, int happiness, int age, int hungerLevel) {
        super(typeName, name, happiness, age, hungerLevel);
    }

    public WalkablePet(Animal a, int hungerLevel) {
        super(a, hungerLevel);
    }

    public WalkablePet(Animal a) {
        super(a);
    }

    public WalkablePet(AnimalType typeName, String name) {
        super(typeName, name);
    }

    /**
     * @param minutes
     */
    @Override
    public void takeWalk(double minutes) {
        increaseHappiness(1);
    }


}
