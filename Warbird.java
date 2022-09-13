import java.util.*;
/**
 * Write a description of class Warbird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warbird extends Force
{
    private boolean cloaking;
     /** Constructor requires the force reference, name
      * of the force, battle strenght and if its to be cloaked 
      * or not
      * @param fleetR is the force reference
      * @param name is the name of the force
      * @param strenght is the battle strengh
      * @param cloaks if it has a cloak or not 
      */
    public Warbird(String fleetR, String name, int strenght,boolean cloaks)
    {
       super(fleetR, name);
       super.setBattleStrength(strenght);
       cloaking = cloaks;
       super.setActivationFee(setActivationFees());
    }
    
    /** returns if the warbird is cloaked or not
     */
    public boolean isCloaked()
    {
        return cloaking;
    }
    
    /** returns the activation fee if the warbird is 
     * cloaked of not
     */
    private int setActivationFees()
    {
        int fee = 0;
        int more = super.getBattleStrenght() + 50;
        if(isCloaked()){fee = 135; super.setBattleStrength(more);}
        else{fee = 95;}
        return fee;
    }
    
    /** returns a string representation of state of
     * the force
     */
    public String toString()
    {
        String st = super.toString();
        String s = st + "Cloaked: " + cloaking;
        return s;
    }
}
