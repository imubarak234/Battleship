import java.util.*;
import java.io.*;
/**
 * Write a description of class Force here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Force 
{
    private String fleetReference;
    private String Name;
    private int activationFee;
    private int battleStrength;
    private ForceState state;
    private String typeForce;
    /**Constructor requires the force reference and
     * the name of the force
     * @param fleetR the force reference 
     * @param name the name of the force
     */
    public Force(String fleetR, String name)
    {
        fleetReference = fleetR;
        Name = name;
        setActivationFee(activationFee);
        setBattleStrength(battleStrength);
        setState("in dock");
        typeForce = getType();
    }

    /** returns a string representation of state of
     * the force
     */
    public String toString()
    {
        String s ="\nFleet Reference: " + fleetReference + " Name: " + Name + 
            " Activation Fee: "+ activationFee + "\nBattle Strenght: " + battleStrength+
            " Force State: " + state.toString() + "\nForce Type: " + typeForce;
        return s;

    }
    
    /** an empty method which is suppose to return 
     * true if the warbird is cloaked
     */
    //public boolean isCloaked(){return false;}
   
    /** returns the force reference number
     */ 
    public String getFleetReference()
    {
        return fleetReference;
    }
    
    /** returns the battle strenght of the force
     */ 
    public int getBattleStrenght()
    {
        return battleStrength;
    }

    /** returns the name of the force
     */
    public String getForceName()
    {
        return Name;
    }
    
    /** returns the activation fee of the force
     */
    public int getActivationFee()
    {
        return activationFee;
    }

    /** takes in an int sets it as the new activation
     * fee
     */
    public void setActivationFee(int fee)
    {
        activationFee = fee;
    }

    /** takes in an int sets it as the new battle
     * strenght
     */
    public void setBattleStrength(int strength)
    {
        battleStrength = strength;
    }
    
    /** returns a string representation of the
     * state of the force
     */
    public String getState()
    {
        return state.toString();
    }
    
    /** returns half the activation fee which is
     * the recall fee
     */
    public int recallFee()
    {
        return activationFee / 5;
    }
    
    
    /** takes in a string represention of a force state
     * and sets the force state to the given input
     * @param st the force state
     */
    public void setState(String st)
    {
        for(ForceState stat: ForceState.values())
        { 
            String t = (stat.toString()).trim();
            if(t.toLowerCase().equals(st.toLowerCase()))
            {
                this.state = stat;
            }
        }
    }
    
    public String getType()
    {
        return this.getClass().getName();
    }

}
