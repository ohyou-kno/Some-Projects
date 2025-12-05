package model.user;

import model.animal.Animal;
import model.animal.Pet;

/**
 * TODO: Class Description
 *
 * @author Gray Ren
 * email: juliaren@usc.edu
 * TAC 265, Spring 2025, Tea Section
 * Date created: 4/17/2025
 */
//asks: the other two constructors. getAllInformation
//methods needed: all of them except for getPet
//methods done: getPet

public class FreeUser extends User{
    //instance variables
    private Pet myPet;

    //constructors
    public FreeUser(String password, String username, Pet myPet) {
        super(password, username);
        this.myPet = myPet;
    }
    public FreeUser(User username, Pet myPet){
        super();
    }
    public FreeUser(User username){
        super();

    }
    public FreeUser(String password, String username){
        super(password, username);
    }

    //other methods

    public  int getNumAnimals(){
        int numAnimals;
        if(myPet == null){
            numAnimals = 0;
        }
        else{
            numAnimals = 1;
        }
        return numAnimals;
    };
    protected  String completeAdoption(Animal animal) {
        String message;
        if(canAdopt(animal) == true){
            message = "You have successfully adopted animal: " + animal.getFullName();
        }
        else{
            message = getAdoptionRules();
        }
        return message;
    };
    public  String getAdoptionRules(){
        return  "A FreeUser can only adopt one animal of type Pet (not Animal Bots). " +
                "Upgrade to adopt more.";
    };
    protected  boolean canAdopt(Animal animal){
        boolean adopted;
        if(myPet == null){
            adopted = true;
        }
        else{
            adopted = false;
        }
        return adopted;
    } ;
    public  String getAllInformation() {

    };
    //equals, hashCode, toString

    //getters n setters n such

    public Pet getPet() {
        return myPet;
    }
}
