package model.animal;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class reads data from the emojiAnimals.csv file
 * @author Kendra Walther
 * email: kwalther@usc.edu
 * ITP 265,
 * Assignment ##
 */

public class AnimalFileReader {
    //constant variable
 private static final String FILE_NAME_SIMPLE = "data/emojiAnimals.csv";
 //reads the emojiAnimal file
 public static ArrayList<AnimalType>  readEmojiAnimalFile() {
     ArrayList<AnimalType> data = new ArrayList<>();
     boolean finished = false;
      try (FileInputStream fis = new FileInputStream(FILE_NAME_SIMPLE);
           Scanner scan = new Scanner(fis)) {
          scan.nextLine(); // skip the header
         while (scan.hasNextLine()) {
          String line = scan.nextLine();
          if (!line.isEmpty()) { //skip empty lines
           AnimalType a = parseLine(line);
           data.add(a);
          }
       }
      } catch (IOException e) {
       System.err.println("Emoji Animals File not found, fix the file location and re-run the program");
        System.exit(1);
       }
     return data;
 }

 private static AnimalType parseLine(String line) {
  Scanner ls = new Scanner(line);
  ls.useDelimiter(","); // comma separated data
  //TypeName,Category,Emoji,canBePet, (for Pet)Sound, walkable
  String type = ls.next();
  String cat = ls.next();
  String emoji = ls.next();
  String pet = ls.next(); //yes or no
  boolean isPet = false;
  String sound = "";
  boolean walkable = false;
  if(pet.equalsIgnoreCase("yes")){
      isPet = true;
      sound = ls.next(); // all pets have sounds.
      if(ls.hasNext()){ // after sound, there might be the word true for walkable.
          walkable = true;
      }
  }
  AnimalCategory category = AnimalCategory.valueOf(cat.toUpperCase());

  return new AnimalType(type, category, emoji, isPet, sound, walkable);
 }
}


	