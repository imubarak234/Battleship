import java.util.*;
import java.io.*;
/**
 * Write a description of class GameIO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameIO
{
    private static SWAT games = new Admiral("Michael Scofield");
    private static Scanner reader = new Scanner(System.in);
    //private static SWAT games1 = new Admiral("Michael", "next");
    
    /**it  displays the option and handles appropriate 
     * methods calls to each option choosen by the user
     */  
    public static void main(String[] args) throws IOException
    {
        try
        {
            int choice = getOption2();
            //if (choice == 1)
            //{
                int second = getOption1();
                while (second != 0)
                {
                    if (second == 1){listForcesAsf();}  
                    else if(second == 2){listFocesAdmiralFleet();}
                    else if(second == 3){getForces();}
                    else if(second == 4){activateForce();}
                    else if(second == 5){engageInFight();}
                    else if(second == 6){restoreForce();}
                    else if(second == 7){recallForce();}
                    else if(second == 8){viewStateOfGame();}
                    else if(second == 9){saveGame();}
                    else if(second == 10){loadGame();}
                    else if(second == 11){listFights();}
                    else if(second == 12){HighScores();}
                    else if(second == 13){listResting();}
                    second = getOption1();
                }
            //}
            //else if(choice == 2){loadGame();}
        }
        catch (NumberFormatException e) {System.out.println("Not a number");}
        catch(InputMismatchException e) {System.out.println("mismatch: put the information in correctly");}
        finally {System.out.println("*********************");}
        System.out.println("Thank you for playing");
    }

    /**displays the options to the terminal window
     * reads and returns the option number choosen
     */
    private static int getOption1()
    {
        System.out.println("0. Quit");
        System.out.println("1. List forces in Allied Space Fleet");
        System.out.println("2. List forces in the Admiral's Fighting Fleet");
        System.out.println("3. Veiw details of a force");
        System.out.println("4.Activate a force into the Admiral's Fighting Fleet");
        System.out.println("5. Engage in a fight");
        System.out.println("6. Restore a force from the resting fleet to the Admiral Forces");
        System.out.println("7. Recall a force from Admiral Fleet or resting forces to the Allied Space Fleet");
        System.out.println("8. View the state of the game");
        System.out.println("9. Save this game");
        System.out.println("10. Restore a game");
        System.out.println("11.List Fights left");
        System.out.println("12. Highscores");
        System.out.println("13. List forces in resting fleet");

        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }
    
    private static int getOption2()
    {
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        int menu = Integer.parseInt(reader.nextLine());
       // reader.nextLine();
        if(menu == 1)
        {
            System.out.println("First Enter you name");
            String name = reader.nextLine();
            games.setName(name);
            difficultyLevel();
        }
        else if(menu == 2)
        {
            loadGame();
        }
        return menu;
    }
    
    private static int difficultyLevel()
    {
        System.out.println("Choose a difficulty level");
        System.out.println("1. Hard");
        System.out.println("2. Medium");
        System.out.println("3. Easy");
        int level = reader.nextInt();
        if(level == 2)
        {
            games.removeFight(7);
            games.removeFight(8);
            games.removeFight(9);
            games.removeFight(10);
        }
        else if (level == 3)
        {
            games.removeFight(10);
            games.removeFight(7);
            games.removeFight(8);
            games.removeFight(9);
            games.removeFight(6);
        }
        return level;
    }

    /** lists the ASf forces to the terminal window
     */
    private static void listForcesAsf()
    {
        System.out.println(games.getASFleet());
    }

    /** lists the admiral forces to the terminal window
     */
    private static void listFocesAdmiralFleet()
    {
        System.out.println(games.getFightingFleet());
    }

    /** prints the details force of which its given is reference
     * to the terminal window
     */ 
    private static void getForces()
    {
        System.out.println("Enter reference code");
        String ref = reader.nextLine();
        // System.out.println("Enter what comes next");
        // int next = reader.nextInt();
        System.out.println(games.getForce(ref));
    }

    /** takes a refernece and activates the force
     * its mapped to
     */
    private static void activateForce()
    {
        System.out.println("Enter reference code");
        String ref = reader.nextLine();
        System.out.println(games.activateForce(ref));
    }

    /** takes a fight number outputs a list of force/s
     * that can partake in the fight and the user puts in the 
     * reference of the desired force and the fight result is
     * out putted to the terminal window
     */
    private static void engageInFight()
    {
        System.out.println("Enter fight number");
        String ft = reader.nextLine();
        int yt = Integer.parseInt(ft);
        System.out.println("**********List of available forces that can partake in this fight **********");
        System.out.println(games.canFight(yt));
        System.out.println("Enter reference number of force you want to use in this fight");
        String st = reader.nextLine();
        System.out.println(games.fight(yt,st));
    }

    /** restores a the force with  the given reference 
     * to the admiral fleet
     */
    private static void restoreForce()
    {
        System.out.println("Enter reference code");
        String ref = reader.nextLine();
        games.restoreForce(ref);
    }

    /** recalls the force with the given reference
     */
    private static void recallForce()
    {
        System.out.println("Enter reference code");
        String ref = reader.nextLine();
        games.recallForce(ref);
    }

    /** outputs to the terminal window the state of the game
     */
    private static void viewStateOfGame()
    {
        System.out.println(games.toString());
    }

    /** saves a game session to a file
     */
    private static void saveGame()
    {
        System.out.println("Enter the file name to save to");
        String ref = reader.nextLine();
        games.saveGame(ref);
    }

    /** loads a game session from the saved file
     */
    private static void loadGame()
    {
        System.out.println("Enter the file name to  load from");
        String ref = reader.nextLine();
        games.loadGamess(ref);
    }
    
    private static void listFights()
    {
        System.out.println(games.getAllFights());
    }
    
    private static void HighScores()
    {
        System.out.println(games.displayLeaderboard());
    }
    
    private static void listResting()
    {
        System.out.println(games.restingFleet());
    }
    
}
    