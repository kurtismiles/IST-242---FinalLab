package Model;

/**
 * File name: Height.java
 * Short description: Creates Height objects
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class Height
{
    //uninitialized attributes
    private int feet;
    private int inches;

    //constructor that takes parameters and assigns to class attributes
    public Height(int inf_feet, int inf_inches)
    {
        feet = inf_feet;
        inches = inf_inches;
    }

    //empty constructor that assigns no parameters but initializes attributes
    public Height()
    {
        feet = 0;
        inches = 0;
    }
    
    //getter and setter methods for feet attribute
    public int getFeet()
    {
        return feet;
    }

    public void setFeet(int inf_feet)
    {
        feet = inf_feet;
    }
    
    //getter and setter methods for inches attribute
    public int getInches()
    {
        return inches;
    }

    public void setInches(int inf_inches)
    {
        inches = inf_inches;
    }

    //gets height in the form of a string
    //may be redundant with toString() method below
    public String getHeight()
    {
        String heightString = feet + " feet" + ", " + inches + " inches";
        return heightString;
    }

    //gets height in the form of the total numbers of inches
    public int getTotalInches()
    {
        int totalInches = (feet * 12) + inches;
        return totalInches;
    }
    
    //Overrides object class to return object data as string
    @Override
    public String toString()
    {
        String toString = feet + "'" + inches + "\"";
        return toString;
        
    }

}
