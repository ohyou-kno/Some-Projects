package model.user;

import model.animal.Animal;

import java.util.Map;
import java.util.Objects;

/**
 * TODO: Class Description
 *
 * @author Gray Ren
 * email: juliaren@usc.edu
 * TAC 265, Spring 2025, Tea Section
 * Date created: 4/17/2025
 */
//asks: getNumAnimals, canAdopt, getAllInformation
//methods needed: getAnimalByName, getAdoptedAnimals, completeAdoption, getSubscriptionFee, getAllAnimalNames
//methods done: 

public class RegularUser extends User{
    //instance variables
    public double subscriptionFee;
    public Map<String, Animal> adoptedAnimals;

    //constants
    public final static int MAX_ANIMALS = 5;
    public final static double  REGULAR_USER_FEE = 10.99;

    //constructors
    public RegularUser(String password, String username) {
        super(password, username);
    }

    //methods
    public  int getNumAnimals(){

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
        return "A RegularUser can adopt up to 5 animals, upgrade to adopt more.";
    };
    protected boolean canAdopt(Animal animal){

    } ;
    public String getAllInformation() {

    };
    //equals, hashCode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RegularUser that = (RegularUser) o;
        return Double.compare(subscriptionFee, that.subscriptionFee) == 0 && MAX_ANIMALS == that.MAX_ANIMALS && Double.compare(REGULAR_USER_FEE, that.REGULAR_USER_FEE) == 0 && Objects.equals(adoptedAnimals, that.adoptedAnimals);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(subscriptionFee);
        result = 31 * result + Objects.hashCode(adoptedAnimals);
        result = 31 * result + MAX_ANIMALS;
        result = 31 * result + Double.hashCode(REGULAR_USER_FEE);
        return result;
    }


    //getters n setters n such


}
