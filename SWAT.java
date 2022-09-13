import java.io.*;
/**
 * This interface specifies the behaviour expected from the SWAT
 */
 
public interface SWAT extends Serializable 
{
 //**************** SWAT **************************  
    
    /**Returns the name of the admiral
     * @return the name of the admiral 
     **/ 
    public String getAdmiralName();
    
    /**Returns a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     **/
    public String toString();
    
    
    /** returns true if resources <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     * @returns true if resources <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     */
    public boolean isDefeated();
    
    /** returns the number of talents in the resources
     * @returns the number of talents in the resources
     */
    public int getResources();
    
    
    /**Returns a String representation of all forces in the Allied Space Fleet(ASF)
     * @return a String representation of all forces in the Allied Space Fleet(ASF)
     **/
    public String getASFleet();
    
    
    /** Returns details of an ASF force with the given reference code
     * @return details of an ASF force with the given reference code
     **/
    public String findForceInASF(String ref);
    
    
    /** Returns details of any force with the given reference code
     * @return details of any force with the given reference code
     **/
    public String getForce(String ref);
    
    
 // ***************** Fighting Fleet Forces ************************   
    /** Allows a force to be activated into the admiral's FightingFleet,  
     * if there are enough resources for the activation fee.The force's 
     * state is set to "active"
     * @param ref represents the reference code of the force
     * @return "Force activated" if force is activated, "Not found" 
     * if force not found, "Not ACTIVE" if force is not in the ASF, 
     * "Not enough resources" if not enough in resources
     **/        
    public String activateForce(String ref);
    
        
    /** Returns true if the force with the reference code is in 
     * the admiral's FightingFleet, false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the admiral's FightingFleet, false otherwise.
     **/
    public boolean isInAdmiralsFleet(String ref);
    
    
    /** Removes a force from the FightingFleet back to the ASF dock if they 
     * are in the FightingFleet
     * pre-condition: isInAdmiralsForce(ref)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref);
        
        
    /**Returns a String representation of the forces in the admiral's Fighting Fleet
     * or the message "No forces activated"
     * @return a String representation of the forces in the admiral's FightingFleet
     **/
    public String getFightingFleet();
    
    
    /**Restores a force to the FightingFleet from resting by setting their 
     * state to ACTIVE 
     * @param the reference code of the force to be restored
     */
    public void restoreForce(String ref);
    
    
    /**Returns a string representations of details of
     * forces that can engage in the given fight
     * @returns s string representations of forces that can engage in the given fight
     * @param the unique fight number
     */ 
    public String canFight(int fightNo);
    
    
//**********************Fights************************* 
    /** returns true if the number represents a fight
     * @param num is the number of the fight
     * @returns true if the number represents a fight
     **/
     public boolean isFight(int num);
     
     
    /** Retrieves the fight represented by the fight number.Finds 
      * a force from the Fighting Fleet which can engage in the fight.The  
      * results of fighting an fight will be one of the following: 
      * "Fight won by  <ref/name of force>“ – add fight gains to the resources, 
      *  and rest the force
      * “Fight lost as no suitable force ACTIVE” – deduct the fight losses 
      * from resources 
      * “Fight lost by <name of force>on battle strength ” - deduct fight 
      * losses from resources, and decommission the force
      * Also includes the state of resources and the force after the fight
      * If a fight is lost and admiral completely defeated (no resources and 
      * no forces to recall), add “You have been defeated ” to the return. 
      * @param fightNo is the number of the fight
      * @return a String showing the result of the fight
      */ 
    public String fight(int fightNo, String force);
    

    /** Provides a String representation of a fight given by 
     * the fight number
     * @param num the number of the fight
     * @return returns a String representation of a fight given by 
     * the fight number
     **/
    public String getFight(int num);
    
    
    /** Provides a String representation of all fights 
     * @return returns a String representation of all fights
     **/
    public String getAllFights();
 
    
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    public void saveGame(String fname);
    
    /** reads all information about the game from the specified file 
     * and returns an Admiral object
     * @param fname name of file storing the game
     * @return the game (as an Admiral object)
     */
    public Object restoreGame(String fname);
    
    public String canfightTostring();
    
    public void removeFight(int remov);
    
    public void setName(String name);
    
    public void leaderBoard();
    
    public String displayLeaderboard();
    
    public void testingHigh();
    
    public String restingFleet();
    
    public void saveGameTxt(String filename);
    
    public void loadGamess(String filename);
    
    public String instructions();
    // public Fight gettFight(int next);
}
