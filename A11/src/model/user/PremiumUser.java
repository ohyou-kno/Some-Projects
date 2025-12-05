package model.user;

import model.animal.Animal;

/**
 * TODO: Class Description
 *
 * @author Gray Ren
 * email: juliaren@usc.edu
 * TAC 265, Spring 2025, Tea Section
 * Date created: 4/17/2025
 */
//asks: getNumAnimals, completeAdoption, getAllInformation
//methods needed:
//methods done: 

public class PremiumUser extends RegularUser implements  Premium{
    //instance variables
    public final static double  PREMIUM_USER_FEE =25.99;

    //constructors
    public PremiumUser(String password, String username) {
        super(password, username);
    }

    //methods
    public  int getNumAnimals(){

    };
    protected  String completeAdoption(Animal animal) {

    };
    public  String getAdoptionRules(){
        return "A PremiumUser can adopt as many animals as they like.";
    };
    protected  boolean canAdopt(Animal animal){
        return true;
    } ;
    public  String getAllInformation() {

    };

    @Override
    public double getPremiumFee() {
        return PREMIUM_USER_FEE;
    }

    @Override
    public boolean isPremium() {
        return true;
    }

    //equals, hashCode, toString

    //getters n setters n such


}
