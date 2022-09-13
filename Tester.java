
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{

    public static void main(String[] args)
    { 
        SWAT adml = new Admiral("Horatio");
        //should say no force active because no had been activated yet 
        System.out.println(adml.toString());

        // prints all forces int ASF Fleet
        System.out.println("**********ASF Fleet**********");
        System.out.println(adml.getASFleet());

       
        //prints the force with the reference in the ASF fleet 
        System.out.println("********************");
        System.out.println(adml.findForceInASF("IW1"));

        //activates forces to 
        System.out.println("********************");
        System.out.println(adml.activateForce("IW1"));
        System.out.println(adml.activateForce("ss2"));
        System.out.println(adml.activateForce("wb3"));
        System.out.println(adml.activateForce("ss6"));
        System.out.println(adml.activateForce("wb5"));
        System.out.println(adml.activateForce("iw10"));
        
        //should return not active
        System.out.println("********************");
        System.out.println(adml.activateForce("IW1"));
        
        //prints out a string representation of all forces in admiral fleet
        System.out.println("**********Admiral Fleet**********");
        System.out.println(adml.getFightingFleet());
        
        
        // should recall the force from the admiral fleet to the ASF fleet
        adml.recallForce("ss2");
        //the above force that was just recalled should not be in the admiral fleet
        System.out.println("**********Admiral Fleet**********");
        System.out.println(adml.getFightingFleet());
        
        
        //adml.restoreForce();
        // returns string representations of forces that can engage in the fight 
        System.out.println("********************");
        System.out.println(adml.canFight(3));
        //should return fight results win
        System.out.println(adml.fight(1,"wb3"));
        //should return a loss
        System.out.println(adml.fight(1,"iw1"));
        System.out.println(adml.fight(4,"WB5"));
        System.out.println("********************");
        //returns the fight with the unique number
        System.out.println(adml.getFight(3));
        System.out.println("********************");
        System.out.println(adml.getAllFights());
    }
}
