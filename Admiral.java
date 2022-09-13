import java.util.*;
import java.io.*; 
import java.awt.Font;


public class Admiral implements SWAT
{
    private int Talents = 1000;
    private String name;
    private HashMap<String, Force> ASF = new HashMap<String, Force>();
    private HashMap<String, Force> admiralForce = new HashMap<String,Force>();
    private HashMap<Integer,Fight> fights = new HashMap<Integer,Fight>();
    private HashMap<String, Force> resting = new HashMap<String, Force>();
    private HashMap<String, Force> canFight = new HashMap<String, Force>();
    private Fight f;
    private Force fs;
    /** Constructor requires the name of the admiral
     * @param admiral the name of the admiral
     */  
    public Admiral(String admiral)
    {
        name = admiral;
        setUpForces();
        setUpFights();
    }

    /**Second constructor requires name of the admiral
     * and file to which to read the ASF fleet from
     * @param admiral the name of the admiral
     * @param fileName name of force setup file
     */
    public Admiral(String admiral, String fileName)
    {
        name = admiral;
        loadGamess(fileName);
        //readFights("fight.dat");
    }

    /** creates, decleares and add forces to the ASF fleet
     */
    private void setUpForces()
    {
        Force f1= new Wing("IW1","Dragons",10);
        Force f2= new Starship("SS2","Enterprise",10,20);
        Force f3 =new Warbird ("WB3","Droop",100,false);
        Force f4 = new Wing("IW4", "Wingers", 20);
        Force f5 = new Warbird("WB5", "Hang", 300, true);
        Force f6 = new Starship("SS6", "Voyager", 15, 10);
        Force f7 = new Starship("SS7", "Explorer", 4, 5);
        Force f8 = new Warbird("WB9", "Hang", 400, false);
        Force f9 = new Wing("IW10", "Flyers", 5);

        ASF.put("IW1",f1);
        ASF.put("SS2",f2);
        ASF.put("WB3",f3);
        ASF.put("IW4",f4);
        ASF.put("WB5",f5);
        ASF.put("SS6",f6);
        ASF.put("SS7",f7);
        ASF.put("WB9",f8);
        ASF.put("IW10",f9);
    }

    /** creates, decleares and add fights to the fight collections
    */
    private void setUpFights()
    {
        //int w2uyyr = 45;
        Fight fgt1 = new Fight("Battle","Borg", 25, 30, 100);
        Fight fgt2 = new Fight("Skirmish","Kardassians", 25, 20,120);
        Fight fgt3 = new Fight("Ambush","Frengi", 35, 40, 150);
        Fight fgt4 = new Fight("Battle", "Ewoks", 35, 60, 200);
        Fight fgt5 = new Fight("Ambush","Borg", 35, 40, 90);
        Fight fgt6 = new Fight("Skirmish","Jabbas", 30, 30,45);
        Fight fgt7 = new Fight("Skirmish","Abbas", 30, 30,45);
        Fight fgt8 = new Fight("Ambush","Yusuf", 50, 60, 70);
        Fight fgt9 = new Fight("Battle","Bosses", 20, 40, 50);
        Fight fgt10 = new Fight("Skirmish", "Youtube", 40, 40, 45);
        
        // int one = fgt1.getUniqueNumber();
        // int second = fgt2.getUniqueNumber();
        // int third = fgt3.getUniqueNumber();
        // int fourth = fgt4.getUniqueNumber();
        // int fifth = fgt5.getUniqueNumber();
        // int sixth = fgt6.getUniqueNumber();
        // int seventh = fgt7.getUniqueNumber();
        // int eighth = fgt8.getUniqueNumber();
        // int nineth = fgt9.getUniqueNumber();
        // int tenth = fgt10.getUniqueNumber();
        

        fights.put(1,fgt1);
        fights.put(2,fgt2);
        fights.put(3,fgt3);
        fights.put(4,fgt4);
        fights.put(5,fgt5);
        fights.put(6,fgt6);
        fights.put(7, fgt7);
        fights.put(8, fgt8);
        fights.put(9, fgt9);
        fights.put(10, fgt10);
     }

    /**reads information from a force setup file, using
     * the information creates appropriate forces and adds 
     * them to the ASF fleet
     * @param fileName name of force setup file
     */
    public void loadGamess(String filename)
    {
        String ints = filename + "Admiral.txt";
        String asf = filename + "Allied.txt";
        String rest = filename + "Resting.txt";
        String nam = filename + "name.txt";
        String talent = filename + "talents.txt";
        String fightt = filename + "fights.txt";
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(asf));
            BufferedReader reader1 = new BufferedReader(new FileReader(ints));
            BufferedReader reader2 = new BufferedReader(new FileReader(rest));
            BufferedReader reader3 = new BufferedReader(new FileReader(nam));
            BufferedReader reader4 = new BufferedReader(new FileReader(talent));
            BufferedReader reader5 = new BufferedReader(new FileReader(fightt));
            ASF.clear();
            admiralForce.clear();
            resting.clear();
            canFight.clear();
            fights.clear();
            String line = reader.readLine();
            while(line != null)
            {
                String[] element = line.split(",");
                String forc = element[0];
                if(forc.equalsIgnoreCase("wing"))
                {
                    int strik =  Integer.parseInt(element[3]);
                    fs = new Wing(element[1],element[2],strik);
                    ASF.put(element[1],fs);
                }
                else if(forc.equalsIgnoreCase("starship"))
                {
                    int torpedos =  Integer.parseInt(element[3]);
                    int cannon =  Integer.parseInt(element[4]);
                    fs = new Starship(element[1],element[2],torpedos,cannon);
                    ASF.put(element[1],fs);
                }
                else if(forc.equalsIgnoreCase("warbird"))
                {
                    boolean cloak = false;
                    int strenght =  Integer.parseInt(element[3]);
                    if(element[4].equals("true")){cloak = true;}
                    fs = new Warbird(element[1],element[2],strenght,cloak);
                    ASF.put(element[1],fs);
                }
                line = reader.readLine();
            }
            
            String line1 = reader1.readLine();
            while(line1 != null)
            {
                String[] element = line1.split(",");
                String forc = element[0];
                if(forc.equalsIgnoreCase("wing"))
                {
                    int strik =  Integer.parseInt(element[3]);
                    fs = new Wing(element[1],element[2],strik);
                    admiralForce.put(element[1],fs);
                }
                else if(forc.equalsIgnoreCase("starship"))
                {
                    int torpedos =  Integer.parseInt(element[3]);
                    int cannon =  Integer.parseInt(element[4]);
                    fs = new Starship(element[1],element[2],torpedos,cannon);
                    admiralForce.put(element[1],fs);
                }
                else if(forc.equalsIgnoreCase("warbird"))
                {
                    boolean cloak = false;
                    int strenght =  Integer.parseInt(element[3]);
                    if(element[4].equals("true")){cloak = true;}
                    fs = new Warbird(element[1],element[2],strenght,cloak);
                    admiralForce.put(element[1],fs);
                }
                line1 = reader1.readLine();
            }
            
            String line2 = reader2.readLine();
            while(line2 != null)
            {
                String[] element = line2.split(",");
                String forc = element[0];
                if(forc.equalsIgnoreCase("wing"))
                {
                    int strik =  Integer.parseInt(element[3]);
                    fs = new Wing(element[1],element[2],strik);
                    resting.put(element[1],fs);
                }
                else if(forc.equalsIgnoreCase("starship"))
                {
                    int torpedos =  Integer.parseInt(element[3]);
                    int cannon =  Integer.parseInt(element[4]);
                    fs = new Starship(element[1],element[2],torpedos,cannon);
                    resting.put(element[1],fs);
                }
                else if(forc.equalsIgnoreCase("warbird"))
                {
                    boolean cloak = false;
                    int strenght =  Integer.parseInt(element[3]);
                    if(element[4].equals("true")){cloak = true;}
                    fs = new Warbird(element[1],element[2],strenght,cloak);
                    resting.put(element[1],fs);
                }
                line2 = reader2.readLine();
            }
            
            String line4 = reader5.readLine();
            while(line4 != null)
            {
                String[] element = line4.split(",");
                int first = Integer.parseInt(element[1]);
                int second = Integer.parseInt(element[3]);
                int third = Integer.parseInt(element[2]);
                int fourth = Integer.parseInt(element[0]);
                Fight figs = new Fight(element[4],element[5], first, second,third);
                figs.setUniqueNumber(fourth);
                fights.put(fourth, figs);
                line4 = reader5.readLine();
            }
            
            String line3 = reader3.readLine();
            this.name = line3;
            int tals = Integer.parseInt(reader4.readLine());
            this.Talents = tals;
        }
        catch (IOException e) {System.out.println(e);}
    }

    /**reads a file containing fight objects and saves
     * them to the fight collection
     * @param files the name of the file with the saved objects
     */
    private void readFights(String files)
    {
        try
        {
            FileInputStream file = new FileInputStream(files);
            ObjectInputStream inf  = new ObjectInputStream (file);
            Fight fig = null;
            fig = (Fight)inf.readObject();
            while (fig != null)
            {
                int st = fig.getUniqueNumber();
                fights.put(st,fig);
                fig = (Fight)inf.readObject();
            }          
        }
        catch (EOFException e){System.out.println("File read");} 
        catch (ClassNotFoundException e){System.out.println(e);}
        catch (IOException e){System.out.println("File not found");}
    }

    /**Returns the name of the admiral
     * @return the name of the admiral 
     **/ 
    public String getAdmiralName()
    {
        return name;
    }

    /**Returns a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     **/
    public String toString()
    {
        String s = " " ; 
        if(isDefeated()){s = "\nName: " + name + "\nResources(Talents): " + Talents + "\ndefeated" + getFightingFleet();}
        else{s = "\nName: " + name + "\nResources(Talents): " + Talents + "\nnot defeated yet: " + getFightingFleet();}
        return s;
    }

    /** returns true if resources <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     * @returns true if resources <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     */
    public boolean isDefeated()
    {
        return Talents <= 0 && admiralForce.isEmpty() && resting.isEmpty() && ASF.isEmpty();
    }

    /** returns the number of talents in the resources
     * @returns the number of talents in the resources
     */
    public int getResources()
    {
        return Talents;
    }

    /**Returns a String representation of all forces in the Allied Space Fleet(ASF)
     * @return a String representation of all forces in the Allied Space Fleet(ASF)
     **/
    public String getASFleet()
    {
        return ASF.values().toString();
    }

    /** Returns details of an ASF force with the given reference code
     * @return details of an ASF force with the given reference code
     **/
    public String findForceInASF(String ref)
    {
        Force form = ASF.get(ref); 
        String st = form.toString();
        return st;
    }

    /** Returns details of an admiral force with the given reference code
     * @returns details of an admiral force with the given reference code
     */
    private String findForceInAdmiralFleet(String ref)
    {
        Force form = admiralForce.get(ref); 
        String st = form.toString();
        return st;
    }

    /** Returns details of a resting force with the given reference code
     * @returns details of a resting force with the given reference code
     */
    private String findForceInResting(String ref)
    {
        Force form = resting.get(ref); 
        String st = form.toString();
        return st;
    }

    /** Returns details of any force with the given reference code
     * @return details of any force with the given reference code
     **/
    public String getForce(String ref)
    {
        String numb = "";
        String st = ref.toUpperCase();
        if(admiralForce.containsKey(st)){numb = findForceInAdmiralFleet(st);}
        else if(ASF.containsKey(st)){numb = findForceInASF(st);}
        else if(resting.containsKey(st)){numb = findForceInResting(st);}
        else{ numb = "not found";}
        return numb;
    }

     
    /** Allows a force to be activated into the admiral's FightingFleet,  
     * if there are enough resources for the activation fee.The force's 
     * state is set to "active"
     * @param ref represents the reference code of the force
     * @return "Force activated" if force is activated, "Not found" 
     * if force not found, "Not ACTIVE" if force is not in the ASF, 
     * "Not enough resources" if not enough in resources
     **/        
    public String activateForce(String ref)
    {
        String active = "";
        String me = ref.toUpperCase();

        if(ASF.containsKey(me))
        {
            Force force = ASF.get(me);
            int numb = force.getActivationFee();
            if( Talents >= numb )
            {
                ASF.remove(me);
                admiralForce.put(me, force);
                force.setState("active");
                active = "Force activated";
                Talents = Talents - numb;
            }
            else if(numb > Talents){active = "Not enough resources";}
        }
        else if(!ASF.containsKey(me) && !admiralForce.containsKey(me) && !resting.containsKey(me)){active = "not found";}
        else if(!ASF.containsKey(me)){active = "No forces in you Allied fleet";}

        return active;
    }

    /** Returns true if the force with the reference code is in 
     * the admiral's FightingFleet, false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the admiral's FightingFleet, false otherwise.
     **/
    public boolean isInAdmiralsFleet(String ref)
    {
        return admiralForce.containsKey(ref);
    }

    /** Removes a force from the FightingFleet back to the ASF dock if they 
     * are in the FightingFleet
     * pre-condition: isInAdmiralsForce(ref)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref)
    {
        String me = ref.toUpperCase();
        if(isInAdmiralsFleet(me))
        {
            Force mmm = admiralForce.get(me);
            int sum = mmm.recallFee();
            Talents = Talents - sum;
            admiralForce.remove(me);
            ASF.put(me, mmm);
        }
        else if(resting.containsKey(me))
        {
            Force why = resting.get(me);
            int sums = why.recallFee();
            //int mum = 0;
            //if(sums >= 100){sums = sums - 100;}
            Talents = Talents - sums;
            resting.remove(me);
            ASF.put(me,why);
        }
    }

    /**Returns a String representation of the forces in the admiral's Fighting Fleet
     * or the message "No forces activated"
     * @return a String representation of the forces in the admiral's FightingFleet
     **/
    public String getFightingFleet()
    {
        String st = "";
        if(admiralForce.isEmpty()){st = "No forces activated";}
        else{st = admiralForce.values().toString();}
        return st;
    }
    
    /**Restores a force to the FightingFleet from resting by setting their 
     * state to ACTIVE 
     * @param the reference code of the force to be restored
     */
    public void restoreForce(String ref)
    {
        String com = ref.toUpperCase();
        if(resting.containsKey(com) && (Talents >= 100))
        {
            Force me = resting.get(com);
            resting.remove(com);
            admiralForce.put(com, me);
            me.setState("active");
            Talents = Talents - 100;
        } 
    }

    //**********************Fights************************* 
    /** returns true if the number represents a fight
     * @param num is the number of the fight
     * @returns true if the number represents a fight
     **/
    public boolean isFight(int num)
    {
        return fights.containsKey(num);
    }

    /** returns a string representation on all forces that
     * can partake in the given fight and adds them to a 
     * canFight collection
     * @param fightNo is the number of the fight
     */
    public String canFight(int fightNo)
    {
        String st = ""; 
        Fight f = fights.get(fightNo);
        String mum = f.getType().toLowerCase().trim();
        // try{
        for(Force form : admiralForce.values())
        {
            String str = form.getType().toLowerCase();
            if((str.equals("wing") || str.equals("starship")) && mum.equals("skirmish")){st = st + form.toString(); canFight.put(form.getFleetReference(),form);}
            else if((str.equals("warbird") || str.equals("starship")) && mum.equals("battle")){st = st + form.toString();canFight.put(form.getFleetReference(),form);}
            else if(str.equals("warbird"))
            {
                Warbird wars = (Warbird) form;
                if(mum.equals("ambush")  && (str.equals("warbird") && wars.isCloaked()))
                {
                    st = st + form.toString();
                    canFight.put(form.getFleetReference(),form);
                }
            }
            else if(mum.equals("ambush")  && str.equals("wing")){st = st + form.toString();canFight.put(form.getFleetReference(),form);}
        }
        if(st.isEmpty()) { st = "No avaiable force in the Admiral fleet to partake in this fight";}
        //  }catch(Exception e) {System.out.println(e);}
        return st;
    }

    /** returns true if the given fight is won by
     * the given force else false
     * @param figh is the number of the fight
     * @param the reference code of the force 
     */
    private boolean fighting(int figh, String force)
    {
        boolean mmii = false;
        String mem = force.toUpperCase();
        // try{
        if(canFight.containsKey(mem) && isFight(figh))
        {
            Fight fig = fights.get(figh);
            Force mmg = canFight.get(mem);
            int me = mmg.getBattleStrenght();
            int you = fig.getEnemyStrenght();
            if(me >= you){mmii = true;}

        }

        // }catch(Exception e) {System.out.println(e);}
        return mmii;
    }

    /** Retrieves the fight and the force represented by the fight number
     * and force refernece. if fighting is true meaning the force overcame
     * the enemy the results will be as follows: 
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
     * @param the reference code of the force 
     * @return a String showing the result of the fight
     */ 
    public String fight(int fightNo,String force)
    {
        //canFight(fightNo);
        String smh = "";
        String mem = force.toUpperCase();
        Fight fig = fights.get(fightNo);
        //Font font1 = new Font(smh , Font.BOLD, 30);
        if(isFight(fightNo))
        {
            if(fighting(fightNo, force) && canFight.containsKey(mem))
            {
                Force fom = canFight.get(mem);
                Talents = Talents + fig. getGain(); 
                smh = "Fight won by " + "===" + fom.getFleetReference() + "/" + fom.getForceName() +  ">";
                fom.setState("Resting");
                resting.put(force, fom);
                fights.remove(fightNo);
                canFight.remove(mem);
                admiralForce.remove(mem);
            }

            else if(canFight.isEmpty())
            {
                smh = "No suitable force to partake in this fight ";
                // Talents = Talents - fig.getLosses();
            }
            else if(!fighting(fightNo, force) && canFight.containsKey(mem))
            {
                Force fom = canFight.get(mem);
                admiralForce.remove(mem);
                canFight.remove(mem);
                smh = "Fight lost by " + " (" + fom.getForceName() + ") " + " on battle strength";
                fom.setState("De-commissioned");
                Talents = Talents - fig.getLosses();
                int newer = fig.getEnemyStrenght() - fom.getBattleStrenght();
                fig.setBattleStrength(newer);
            }
            else if(fights.isEmpty()){smh = "You have won as no fights are left";}
            else{smh = "force can not engage in this fight";}
        }
        else{smh = "Fight has been fought or does not exist";}
        if(fights.isEmpty()){smh = "********************* YOU HAVE WON!!! **********************"; leaderBoard();}
        if(admiralForce.isEmpty() && ASF.isEmpty() && resting.isEmpty()){smh = "***************** YOU LOST!! TRY AGAIN *****************";}
        return smh;
    }

    /** Provides a String representation of a fight given by 
     * the fight number
     * @param num the number of the fight
     * @return returns a String representation of a fight given by 
     * the fight number
     **/
    public String getFight(int num)
    {
        Fight fig = fights.get(num);
        String st = fig.toString();
        return st;
    }

    /** Provides a String representation of all fights 
     * @return returns a String representation of all fights
     **/
    public String getAllFights()
    {
        return fights.values().toString();
    }

    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    public void saveGame(String fname) 
    {
        try
        {
            FileOutputStream file = new FileOutputStream(fname);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this.getClass());
            out.close();
        }
        catch (IOException e){System.out.println(e);}
    }

    /** reads all information about the game from the specified file 
     * and returns an Admiral object
     * @param fname name of file storing the game
     * @return the game (as an Admiral object)
     */
    public Admiral restoreGame(String fname)
    {
        //Admiral mmg = this.getClass();
        //mmg = null;
        Admiral mmg = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(fname);
            ObjectInputStream fileOut= new ObjectInputStream(fileIn);
            mmg = (Admiral)fileOut.readObject();  // make sure to cast object
            //man = mmg;
            fileOut.close();
            fileIn.close();
            //return mmg;
        }
        catch (FileNotFoundException e){System.out.println("File not found");}
        catch (IOException e){System.out.println(e);}
        catch (ClassNotFoundException e){System.out.println(e);} 
        return mmg;
    }
    
    public String canfightTostring()
    {
        String wxy = canFight.values().toString();
        return wxy;
    }
    
    public void removeFight(int remov)
    {
       // Fight fix = fights.get(remov);
        fights.remove(remov);
    }
    
    public void printFights()
    {
        System.out.println(getAllFights());
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void leaderBoard()
    {
        try
        {
            String message = "Name: " + name + "\t" + "Score: " + Talents;
            PrintWriter outputs = new PrintWriter(new FileWriter("Highscorek.txt", true));
            outputs.println(message);
            outputs.close();
        }
        catch (IOException e) {System.out.println(e);}
    }
    
    public String displayLeaderboard()
    {
        String next = "";
        Scanner input = null;
        try
        {
            FileReader filein = new FileReader("Highscorek.txt");
            input = new Scanner(filein);
        } catch(FileNotFoundException e) {System.out.println("Error");}
        while(input.hasNext())
        {
            next = next + input.nextLine() + "\n";
        }
        return next;
    }
    
    public void testingHigh()
    {
        System.out.println(displayLeaderboard());
    }
    
    public String restingFleet()
    {
        String xyz;
        if(resting.isEmpty()){xyz = "No forces in the resting fleet";}
        else {xyz = resting.values().toString();}
        return xyz;
    }
    
    public void saveGameTxt(String filename)
    {
        String ints = filename + "Admiral.txt";
        String asf = filename + "Allied.txt";
        String rest = filename + "Resting.txt";
        String nam = filename + "name.txt";
        String talent = filename + "talents.txt";
        String fightt = filename + "fights.txt";
        try
        {
          PrintWriter outputs = new PrintWriter(new FileWriter(ints));
          PrintWriter outputs1 = new PrintWriter(new FileWriter(asf));
          PrintWriter outputs2 = new PrintWriter(new FileWriter(rest));
          PrintWriter outputs3 = new PrintWriter(new FileWriter(nam));
          PrintWriter outputs4 = new PrintWriter(new FileWriter(talent));
          PrintWriter outputs5 = new PrintWriter(new FileWriter(fightt));
            for(Force form : admiralForce.values())
          {
           
            if(form.getType().equalsIgnoreCase("wing"))
          {
              Wing xyz = (Wing) form;
              String rms = "Wing," + form.getFleetReference() + "," + form.getForceName() + "," + xyz.getStrikers();
              outputs.println(rms);
          }
          else if(form.getType().equalsIgnoreCase("warbird"))
          {
              Warbird sec = (Warbird) form;
              String wty = "Warbird," + form.getFleetReference() + "," + form.getForceName() + "," + sec.getBattleStrenght() + "," + sec.isCloaked();
              outputs.println(wty);
          }
          else if(form.getType().equalsIgnoreCase("starship"))
          {
              Starship ends = (Starship) form;
              String means = "Starship," + form.getFleetReference() + "," + form.getForceName() + "," + ends.getLaserCannon() + "," + ends.getPhotonTorpedos();
              outputs.println(means);
          }
          
        }
        
          for(Force form : ASF.values())
          {
           
            if(form.getType().equalsIgnoreCase("wing"))
          {
              Wing xyz = (Wing) form;
              String rms = "Wing," + form.getFleetReference() + "," + form.getForceName() + "," + xyz.getStrikers();
              outputs1.println(rms);
          }
          else if(form.getType().equalsIgnoreCase("warbird"))
          {
              Warbird sec = (Warbird) form;
              String wty = "Warbird," + form.getFleetReference() + "," + form.getForceName() + "," + sec.getBattleStrenght() + "," + sec.isCloaked();
              outputs1.println(wty);
          }
          else if(form.getType().equalsIgnoreCase("starship"))
          {
              Starship ends = (Starship) form;
              String means = "Starship," + form.getFleetReference() + "," + form.getForceName() + "," + ends.getLaserCannon() + "," + ends.getPhotonTorpedos();
              outputs1.println(means);
          }
          
        }
        
        for(Force form : resting.values())
          {
           
            if(form.getType().equalsIgnoreCase("wing"))
          {
              Wing xyz = (Wing) form;
              String rms = "Wing," + form.getFleetReference() + "," + form.getForceName() + "," + xyz.getStrikers();
              outputs2.println(rms);
          }
          else if(form.getType().equalsIgnoreCase("warbird"))
          {
              Warbird sec = (Warbird) form;
              String wty = "Warbird," + form.getFleetReference() + "," + form.getForceName() + "," + sec.getBattleStrenght() + "," + sec.isCloaked();
              outputs2.println(wty);
          }
          else if(form.getType().equalsIgnoreCase("starship"))
          {
              Starship ends = (Starship) form;
              String means = "Starship," + form.getFleetReference() + "," + form.getForceName() + "," + ends.getLaserCannon() + "," + ends.getPhotonTorpedos();
              outputs2.println(means);
          }
          
        }
        
        for(Fight figs : fights.values())
        {
            String whats =figs.getUniqueNumber() + "," + figs.getEnemyStrenght() + "," + figs.getGain()
            + "," + figs.getLosses() + "," + figs.getType() + "," + figs.getEnemy();
            outputs5.println(whats);
            
        }
        
        outputs3.println(this.name);
        outputs4.println(this.Talents);

        outputs.close();
        outputs1.close();
        outputs2.close();
        outputs3.close();
        outputs4.close();
        outputs5.close();
        }catch (IOException e) {System.out.println(e);}
    }
    
    public String instructions()
    {
        String intr = "The game begins with 10 different focres consisting Wings, Starship and Warbird"
        + " and 3 different fights Ambush, Battle and skirmish"+ "\n" + "The wing can be used in a skirmish or an Ambush"
        + "\n" + "The Starship can be used in a battle and a skirmish" + "\n"
        + "The Warbird can be used in an Ambush or a battle" + "\n" +
        "Each fight has a main boss to defeat in other to clear that fight" +
        " You start with 1000 Talents: This talents are used" + "\n" +
        "To activate forces(to the fighting fleet), recall forces(to the allied fleet)" + "\n" 
        + "If a fight is won talents are add but if lost talents are deducted" + "\n" +
        "Defeat all the fights and the game is won....Lose all your forces and the game is lost";
        return intr;
    }
    
    // public void setAdmiral(Admiral hush)
    // {
        // this = hush; 
    // }
    
    // public Fight gettFight(int next)
    // {
        // Fight homes = fights.get(next);
        // return homes;
    // }
    
    // public void addFight(String type,String enemie,int eneStr, int loss,int gain)
    // {
       // //Fight test = k
    // }
    
}
