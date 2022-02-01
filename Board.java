/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board() {
    phrase = loadPhrase();
  }
  
  /* your code here - accessor(s) */
  public String getPhrase() {
    return phrase;
  }

  public String getSolvedPhrase() {
    return solvedPhrase;
  }

  public int getCurrentLetterValue() {
    return currentLetterValue;
  }
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";

    int numOfLines = 0;
    try
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    int randomInt = (int) ((Math.random() * numOfLines) + 1);

    try
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }
      else
      {
        solvedPhrase += "_ ";
      }
    }

    return tempPhrase;
  }

  // Creates a new solved phrase only showing correctly guessed
  //letters by substituting them into there exact index by using spaces
    
  //Preconditions: need a guessed letter and a phrase to look for it in
  //Postconditions - solvedPhrase now has guessed letter in correct spaces
  public boolean guessLetter(String guess)
  {
    // Define/initialize variables needed
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    
    // Runs for every character in the phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      // If currect indexed character is equal to guess then run code
      if (phrase.substring(i, i + 1).equals(guess))
      {
        // Add the guessed letter to the solved phrase
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      // If not correct character at that index
      else
      {
        // Add spaces to make substituted letters have correct index
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    // Value of old solvedPhrase equal to the new one we just created
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  } 
} 