package Model;

/**
 * File name: Model.java
 * Short description: Creates fpData object 
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class Model
{ 
    //uninitialized attributes
    private FootballPlayerData fpData;
    
    //constructor
    public Model()
    {
        fpData = new FootballPlayerData();
    }
    
    //getter and setter method for fpData
    public FootballPlayerData getFpData()
    {
        return fpData;
    }
    
    public void setFpData(FootballPlayerData fpData)
    {
        this.fpData = fpData;
    }
}
