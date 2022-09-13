
/**
 * Write a description of class Wing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wing extends Force
{
    private int striker;

    /** Constructor requires the force reference, name
     * of the force and the amount of strikers
     * @param fleetR is the force reference
     * @param name is the name of the force
     * @param strik is the amount of strikers
     */
    public Wing(String fleetR, String name, int strik)
    {
        super(fleetR, name);
        super.setActivationFee(45);
        striker = strik;
        super.setBattleStrength(getbattleStrenght(strik));
    }

    /** returns the amount of strikers
     */
    public int getStrikers()
    {
        return striker; 
    }

    /**returns the battle strenght after it has been
     * processed 
     * @param strik the number of srikers
     */
    private int getbattleStrenght(int strik)
    {
        int strenght = strik * 20;
        return strenght;
    }

    /** returns a string representation of state of
     * the force
     */
    public String toString()
    {
        String st = super.toString();
        String s = st + " Striker: " + striker;
        return s;
    }
    
    
}
