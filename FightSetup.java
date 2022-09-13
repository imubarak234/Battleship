import java.io.*;
import java.util.*;
/**
 * Write a description of class FightSetup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FightSetup implements Serializable
{
    private static ArrayList<Fight> fig = new ArrayList<Fight>();
    private static Scanner read = new Scanner(System.in);
    
    /** creates fight objects saves the to an arrylist
     * and saves the to a file
     */
    public static void main(String[] args) throws IOException
    {
        try
        {
            int count = 0;
            System.out.println("Begin by pushing the enter button");
            while(!read.nextLine().equals("done"))
            {
                System.out.println("Enter enemy name");
                String en = read.nextLine();
                System.out.println("Enter fight type");
                String ty = read.nextLine();
                System.out.println("Enter enemy strenght");
                int str = read.nextInt();
                System.out.println("Enter the fight gain");
                int gain = read.nextInt();
                System.out.println("Enter the fight loss");
                int loss = read.nextInt();
                Fight fight = new Fight(ty,en,str,loss,gain);
                fig.add(fight);
                count++;
                System.out.println("You have succesfully created " + count + " fight/s push the enter button to creat another type done to stop");
                read.nextLine();
             
            }
        }
        catch (NumberFormatException e) {System.out.println("Not a number");}
        catch(InputMismatchException e) {System.out.println("mismatch: put the information in correctly");}
        finally {System.out.println("*********************");}
        writeToFile();
        System.out.println("Thank-you");
    }

    /** saves the elements in the fig arraylist 
     * to a fight
     */
    private static void writeToFile() throws IOException
    {
        FileOutputStream file = new FileOutputStream("fight.dat");
        ObjectOutputStream out = new ObjectOutputStream(file);
        for(Fight asap : fig)
        {
            out.writeObject(asap);
        }
        out.close();
    }
    }

