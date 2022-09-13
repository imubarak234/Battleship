import java.util.*;
/**
 * Write a description of class Starship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Starship extends Force
{
    private int laserCannon;
    private int photonTorpedos;
    /** Constructor requires the force reference, name
     * of the force, the amount of laser cannon and
     * photon torpedos
     * @param fleetR is the force reference
     * @param name is the name of the force
     * @param lasers the amonut of laser cannons
     * @param torpedos the amount of photon torpedos
     */
    public Starship(String fleetR, String name,int lasers, int torpedo)
    {
        super(fleetR, name);
        photonTorpedos = torpedo;
        laserCannon = lasers;
        super.setActivationFee(geActivationFees(lasers, torpedo));
        super.setBattleStrength(getbattlestre(torpedo, lasers));
    }

    /** returns the amonut of laser cannons
     */
    public int getLaserCannon()
    {
        return laserCannon;
    }

    /** returns the amount of photon torpedos
     */
    public int getPhotonTorpedos()
    {
        return photonTorpedos;
    }

    /** returns the activation fee after being processed
     * @param laser is the amount of laser cannons
     */
    private int geActivationFees(int laser, int photon)
    {
        int fee = (laser * 10) + (photon * 8);
        return fee;
    }

    /** returns the battle strength after being processed
     *  @param laser is the amount of laser cannons
     */
    private int getbattlestre(int torpedos, int cannon)
    {
        int strenght = (torpedos * 5) + (cannon * 10);
        return strenght;
    }

    /** returns a string representation of state of
     * the force
     */
    public String toString()
    {
        String s = super.toString();
        String st =s + "LaserCannon: " + laserCannon + "photonTorpedos: " + photonTorpedos;
        return s;
    }

}
