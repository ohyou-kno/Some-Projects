package Controller;

import model.animal.AnimalType;
import model.user.User;
import View.MyIO;
import View.UI;

import java.util.List;
import java.util.Map;

/**
 * TODO: Class Description
 *
 * @author Gray Ren
 * email: juliaren@usc.edu
 * TAC 265, Spring 2025, Tea Section
 * Date created: 4/17/2025
 */
//asks: 
//methods needed:
//methods done: 

public class MainSystem {
    //instance variables
    private Map<String, User> userDatabase; //String is the unique username
    private List<AnimalType> allAnimals;
    private User loggedInUser; //null when no User is logged in
    private UI ui;

    private static final String DB_FILE = "userDatabase.ser";

    //constructors

    //methods
    public void run() {
        boolean quit = false;
        while (!quit) {
            LoginMenu option;
            if(ui instanceof MyIO) {
                int userChoice = ui.readInt(LoginMenu.getMenuString() + "\n>",
                        0, LoginMenu.values().length - 1);
                option = LoginMenu.getOptionNumber(userChoice);
            }else{ //Popup
                option = (LoginMenu) ui.chooseFrom("Pick menu option: ", (Object[])LoginMenu.values());
            }
            switch (option) {
                case LOGIN -> login();
                case LOGOUT -> loggedInUser = null;
                case SHOW_USERNAMES -> displayUsernames();
                case DISPLAY_USERS -> displayUsers();
                case CREATE_ACCOUNT -> createAccount();
                case CHANGE_PASSWORD -> {
                    if (isUserLoggedIn()) {
                        changePassword(); }
                }
                case ADOPT_PET -> {
                    if (isUserLoggedIn()) {
                        adoptPet();
                    }
                }
                case INTERACT_WITH_PET -> {
                    if (isUserLoggedIn()) {
                        interactWithPet();
                    }
                }
                case DISPLAY_USER -> {
                    ui.println(loggedInUser.getAllInformation());
                }
                case UPGRADE_ACCOUNT -> {
                    if (isUserLoggedIn()) {
                        upgrade();
                    }
                }
                case QUIT ->{
                    quit = true;
                    UserDatabaseSaver.writeObjectToFile(userDatabase, DB_FILE);
                }

            }
            if (!quit) { //pause
                if(ui instanceof MyIO) ui.readln("enter something to continue");
            }
        }
    }

    private void login() {
        boolean logging;
        if(loggedInUser == null){

        }
        else{
            ui.println("You have to log out first before logging into a new user");
            logging = ui.readYesOrNo("Would you like to logout?");
            if(logging == true){
                logout();
            }
        }

    }
    private void logout(){
        loggedInUser = null;
    }

    private void displayUsernames(){

    }
    private void displayUsers(){

    }
    private void createAccount(){
        String username = ui.readln("Hello! To create an account please make a username");
        confirmPassword();

    }
    private void confirmPassword(){

    }
    private boolean  isUserLoggedIn(){
        return true;
    }
    private void changePassword(){
        if(loggedInUser != null){

        }

    }
    private void adoptPet(){

    }
    private void interactWithPet(){

    }
    private void upgrade(){

    }
    //equals, hashCode, toString

    //getters n setters n such


}
