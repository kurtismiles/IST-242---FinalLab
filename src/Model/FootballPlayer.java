package Model;

import java.util.ArrayList;

/**
 * File name: FootballPlayer.java
 * Short description: Creates FootballPlayer object by extending person class 
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class FootballPlayer extends Person implements TableMember
{
    //uninintialized class attributes for FootballPlayer
    private int number;
    private String position;

    //contructor that takes parameters and assigns to class attributes
    public FootballPlayer(String inf_name, Height inf_height, int inf_weight,
            String inf_hometown, String inf_highSchool, int inf_number,
            String inf_position)
    {
        super(inf_name, inf_height, inf_weight, inf_hometown, inf_highSchool);
        number = inf_number;
        position = inf_position;
    }

    //empty constructor that assigns no parameters but initializes attributes
    public FootballPlayer()
    {
        super();
        number = 0;
        position = "";
    }

    //getter and setter methods for number attribute
    public int getNumber()
    {
        return number;
    }

    public void setNumber(int inf_number)
    {
        number = inf_number;
    }

    //getter and setter methods for position attribute
    public String getPosition()
    {
        return position;
    }

    public void setPosition(String inf_position)
    {
        position = inf_position;
    }
    
    //-----------------------------------------
    //methods implemented from TableMember.java
    //-----------------------------------------
    
    /*
    Overrides person superclass to use object superclass toString() method.
    Adds additional number and position attribute to superclass method.
    Returns data about object as string.
    */
    @Override 
    public String toString()
    {
        String toString = super.toString() + ", " + number + ", " + position;
        return toString;
    }
    
    //returns string attribute based on int parameter
    @Override
    public String getAttribute(int n)
    { 
       String returnAttribute = new String();
        
        if (n == 0)
        {
            returnAttribute = this.getName();
        }
        if (n == 1)
        {
            returnAttribute = "" + this.getHeight().toString();
        }
        if (n == 2)
        {
            returnAttribute = "" + this.getWeight();
        }
        if (n == 3)
        {
            returnAttribute = this.getHometown();
        }
        if (n == 4)
        {
            returnAttribute = this.getHighschool();
        }
        if (n == 5)
        {
            returnAttribute = "" + this.getNumber();
        }
        if (n == 6)
        {
            returnAttribute = "" + this.getPosition();
        }
        
        return returnAttribute;  
    }
    
    //returns a String Arraylist filled with all attributes
    @Override
    public ArrayList<String> getAttributes()
    {
        ArrayList<String> attributeList = new ArrayList<>(7);
        
        for (int i = 0; i < 7; ++ i)
        {
        attributeList.add(i, getAttribute(i));
        }
        
        return attributeList;  
    }
    
    //returns string representation of attribute based on int parameter input
    @Override
    public String getAttributeName(int n)
    {
        String returnAttribute = new String();
        
        if (n == 0)
        {
            returnAttribute = "name";
        }
        if (n == 1)
        {
            returnAttribute = "height";
        }
        if (n == 2)
        {
            returnAttribute = "weight";
        }
        if (n == 3)
        {
            returnAttribute = "hometown";
        }
        if (n == 4)
        {
            returnAttribute = "highSchool";
        }
        if (n == 5)
        {
            returnAttribute = "number";
        }
        if (n == 6)
        {
            returnAttribute = "position";
        }
        
        return returnAttribute;   
    }
    
    //returns a String ArrayList filled with names of all attributes
    @Override
    public ArrayList<String> getAttributeNames()
    {
        ArrayList<String> attributeList = new ArrayList<>(7);

        for (int i = 0; i < 7; ++ i)
        {
        attributeList.add(i, getAttributeName(i));
        }
        
        return attributeList;
    }

}
