/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private boolean activeGame;
  private Player player1;
  private Player player2;
  private Board board;

  /* your code here - constructor(s) */ 
  public PhraseSolver() 
  {
    activeGame = true;
  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to two-player hangman!");
    System.out.println("When it's your turn guess either a letter or a word.");
    System.out.println("What's your name player one? ");
    player1 = new Player(input.nextLine());
    System.out.println("What's your name player two? ");
    player2 = new Player(input.nextLine());

    board = new Board();
    boolean player1Turn = true;

    while (activeGame)
    {
      /* your code here - game logic */
      System.out.println("Current phrase: " + board.getSolvedPhrase());
      if (player1Turn)
      {
        System.out.println(player1.getName() + "'s turn. What's your guess? ");
      }
      else
      {
        System.out.println(player2.getName() + "'s turn. What's your guess? ");
      }

      String guess = input.nextLine();

      if (guess.length() != 1) 
      {
        if (board.getPhrase().equalsIgnoreCase(guess)) 
        {
          activeGame = false;
        } 
        else 
        {
          System.out.println("That's not the correct full phrase!");
        }
      } 
      else 
      {
        boolean wasGuessCorrect = board.guessLetter(guess);
        if (wasGuessCorrect) 
        {
          if (player1Turn) player1.addScore(board.getCurrentLetterValue());
          else player2.addScore(board.getCurrentLetterValue());
        }
        if (wasGuessCorrect)
        {

            System.out.println("That's correct.");

        }
        else
        {
            System.out.println("That letter was not found in this phrase.");

        }
      }
      if (player1Turn)
      {
        player1Turn = false;
      }
      else
      {
        player1Turn = true;
      }
      System.out.println();
    }
    if (player1Turn)
    {
        System.out.println("You guessed it! Congrats! The winner is " + player2.getName());
    }
    else
    {
        System.out.println("You guessed it! Congrats! The winner is " + player1.getName());
    }
    input.close();
  }
}