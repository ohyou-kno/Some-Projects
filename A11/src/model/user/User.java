package model.user;

import model.animal.Animal;

import java.util.Objects;

/**
 * TODO: Class Description
 *
 * @author Gray Ren
 * email: juliaren@usc.edu
 * TAC 265, Spring 2025, Tea Section
 * Date created: 4/17/2025
 */
//asks: hashcode, updatePassword, toString
    //
//methods needed:
//methods done: 

public abstract class User {
    //instance variables
    private String password;
    private final String username;

    //constructors
    public User(String password, String username){
        this.password = password;
        this.username = username;
    }
    public User(User username, String username1){
        this.username = username1;
    }



    public boolean verifyPassword(String passwordAttempt){
        boolean correct;
        if(passwordAttempt == password){
            correct = true;
        }
        else{
            correct = false;
        }
        return correct;
    };
    public boolean updatePassword(String password, String newPassword){
        boolean update;
        if(password == ){
            password = newPassword;
            update = true;
        }
        else{
            update = false;
        }
        return update;
    };
    public abstract int getNumAnimals();
    protected abstract String completeAdoption(Animal animal) ;
    public abstract String getAdoptionRules();
    protected abstract boolean canAdopt(Animal animal) ;
    public abstract String getAllInformation() ;

    public final String adopt(Animal animal){
        String message;
        if(canAdopt(animal)){
            message = completeAdoption(animal);
        }
        else{
            message = "Adoption is not allowed: " + getAdoptionRules();
        }
        return message;
    }

    //equals, hashCode, toString

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(password, user.password) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(password);
        result = 31 * result + Objects.hashCode(username);
        return result;
    }
/**
    @Override
    public String toString() {
        return """\
                User{
                    password='$password',
                    username='$username'
                }"""
    }
    */

    //getters n setters n such


}
