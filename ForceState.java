import java.io.*;
/**
 * @author A.Marczyk
 * @version 02/02/2013
 */
public enum ForceState implements Serializable
{
    DOCKED(" In dock"), ACTIVE(" Active"), RESTING(" Resting"),DECOMMISSIONED (" De-commissioned");
    private String state;
    
    private ForceState(String st)
    {
        state = st;
    }
    
    public String toString()
    {
        return state;
    }
}
