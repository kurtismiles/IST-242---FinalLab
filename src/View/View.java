package View;

import java.util.ArrayList;

/**
 * File name: View.java
 * Short description: Creates and manipulates an InitialFrame object as mf
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class View
{   
    //uninitialized attributes
    private InitialFrame mf;
    
    //constructor
    public View()
    {
        mf = new InitialFrame();
    }

    //getter and setter method for mf
    public InitialFrame getMf()
    {
        return mf;
    }

    public void setMf(InitialFrame mf)
    {
        this.mf = mf;
    }
 
    //sets up the center panel with given rows and columns  
    public void CenterInitialSetup(int x, int y)
    {
        mf.getIp().getCp().initializeLayout(x, y);
    }
    
    //fills center panel with player data and header names
    public void CenterUpdate(ArrayList<ArrayList<String>> playerData,
            ArrayList<String> headerNames)
    {
        mf.getIp().getCp().updateLayout(playerData, headerNames);
    }
}
