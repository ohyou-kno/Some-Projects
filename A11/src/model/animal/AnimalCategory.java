package model.animal;

import java.io.Serializable;

public enum AnimalCategory implements Serializable {
 AQUATIC,
 BIRD,
 IMAGINARY,
 INSECT,
 MAMMAL,
 REPTILE;

 // Creates the opening menu with all the available categories of animals
 // used to show user all available animal categories
 public static String getMenuString(){
  StringBuilder menu = new StringBuilder("Let's start by choosing a category of animal:\n");
  for (AnimalCategory op : AnimalCategory.values()) {
     menu.append(op.ordinal()).append(": ").append(op).append("\n");
  }
   menu.append("Which category number do you want?\n");
  return menu.toString();
 }
 //gets the number of the category
 public static AnimalCategory getCategoryNumber(int n) {
  return AnimalCategory.values()[n];
 }
}