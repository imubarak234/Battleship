import java.util.*;
import java.io.*;
/**
 * Write a description of class Fight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fight implements Serializable
{
    private static int nextNumber=1;
    private int uniqueNumber;
    private int enemyStrenght;
    private int gains;
    private int losses;
    private String enemy;
    private FightType type;
    /** Constructor requires the type of fight, enemy name, 
     * enemy strenght, fight loss and fight gain
     * @param type is the fight type
     * @param enemie is the enemy name
     * @param loss is the fight loss
     * @param gain is the fight gain
     */
    public Fight(String type,String enemie,int eneStr, int loss,int gain ) //throws IOException
    {
        //this.type = type;
        uniqueNumber = nextNumber;
        nextNumber++;
        enemyStrenght = eneStr;
        gains = gain;
        losses = loss;
        enemy = enemie;
        if(isState(type)){setType(type);}
    }

    /** returns the unique number
     */
    public int getUniqueNumber()
    {
        return uniqueNumber;
    }

    /**returns the enemy strenght
     */
    public int getEnemyStrenght()
    {
        return enemyStrenght; 
    }

    /** returns the gain
     */ 
    public int getGain()
    {
        return gains;
    }

    /** returns the losses
     */ 
    public int getLosses()
    {
        return losses;
    }

    /** returns the fight type of the fight
     */
    public String getType()
    {
        String you = "";
        if(type != null)
        {
           String ma = type.toString();
           you = ma;  
        }
        return you;
    }

    /** returns the name of the fight enemy
     */
    public String getEnemy()
    {
        return enemy;
    }

    /** returns true if the String parameter st 
     * is a fight type
     * @param st is the fight type
     */
    public boolean isState(String st)
    {
        String why = st.trim();
        boolean faith = false;
        if(why.equals("Skirmish")){faith = true;}
        else if(why.equals("Ambush")){faith = true;}
        else if(why.equals("Battle")){faith = true;}
        return faith;
    }

    /** returns a string representation of the state of
     * the fight
     */
    public String toString()
    {
        String s ="\nUnique number #: " + uniqueNumber + " Enemy Strenght: " + enemyStrenght
            + "\n Gains: " + gains + " Losses: " + losses + " Type: " +  getType() +
            "\n Enemy Name: " + enemy;
        return s;
    }

    /** sets the fight type to the given string
     * parameter
     * @param ty is the fight type
     */
    public void setType(String ty)
    {
        for(FightType typ: FightType.values())
        {
            String t = (typ.toString()).trim();
            if(t.toLowerCase().equals(ty.toLowerCase()))
            {
                this.type = typ;
            }
        }
    }
    
    public void print()
    {
        System.out.println(toString());
    }
    
    public void setBattleStrength(int str)
    {
        enemyStrenght = str;
    }
    
    public void setUniqueNumber(int newNo)
    {
        uniqueNumber = newNo;
    }

}
