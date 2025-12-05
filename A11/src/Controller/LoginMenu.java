package Controller;

/**
 * TODO: Class Description
 *
 * @author Gray Ren
 * email: juliaren@usc.edu
 * TAC 265, Spring 2025, Tea Section
 * Date created: 4/17/2025
 */
//package controller;
public enum LoginMenu {
    CREATE_ACCOUNT("Create an account"),
    LOGIN("Login"),
    LOGOUT("Logout"),
    CHANGE_PASSWORD("Change password"),
    SHOW_USERNAMES("Display all usernames"),
    DISPLAY_USERS("Display all user details"),

    ADOPT_PET("Adopt a pet (requires login)"),
    DISPLAY_USER("Display current user and their pets (requires login)"),
    INTERACT_WITH_PET("Interact with an adopted pet (requires login)"),
    UPGRADE_ACCOUNT("Upgrade account type"),
    QUIT("Quit");

    private final String option;

    LoginMenu(String description) {
        this.option = description;
    }

    @Override
    public String toString() {
        return option;
    }

    public static LoginMenu getOptionNumber(int n) {
        return LoginMenu.values()[n];
    }

    public static String getMenuString() {
        StringBuilder menu = new StringBuilder("Menu Options:\n");
        for (LoginMenu option : LoginMenu.values()) {
            menu.append(option.ordinal()).append(": ").append(option.option).append("\n");
        }
        return menu.toString();
    }
}

