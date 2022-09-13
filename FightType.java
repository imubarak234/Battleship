import java.io.*;
import java.util.*;
/**
 * @author A.Marczyk
 * @version 02/02/2013
 */
public enum FightType implements Serializable
{
    SKIRMISH (" Skirmish"), AMBUSH(" Ambush"), BATTLE(" Battle") ;
    private String type;
    private FightType(String ty)
    {
        type = ty;
    }
    
    public String toString()
    {
        return type;
    }
}
