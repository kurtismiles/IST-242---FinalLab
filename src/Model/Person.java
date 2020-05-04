package Model;

/**
 * File name: Person.java
 * Short description: Creates person object
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class Person
{   
    //unintialized protected attributes
    protected String name;
    protected Height height;
    protected int weight;
    protected String hometown;
    protected String highSchool;

    //constructor that takes parameters
    public Person(String inf_name, Height inf_height, int inf_weight,
            String inf_hometown, String inf_highSchool)
    {
        name = inf_name;
        height = inf_height;
        weight = inf_weight;
        hometown = inf_hometown;
        highSchool = inf_highSchool;
    }

    //empty constructor that initializes variables
    public Person()
    {
        height = new Height(0, 0);
        weight = 0;
        hometown = "";
        highSchool = "";
        name = "";
    }

    //getter and setter methods for name attribute
    public String getName()
    {
        return name;
    }

    public void setName(String inf_name)
    {
        name = inf_name;
    }

    //getter and setter methods for height attribute
    public Height getHeight()
    {
        return height;
    }

    public void setHeight(Height inf_height)
    {
        height = inf_height;
    }

    //getter and setter methods for weight attribute
    public int getWeight() {
        return weight;
    }

    public void setWeight(int inf_weight)
    {
        weight = inf_weight;
    }

    //getter and setter methods for hometown attribute
    public String getHometown()
    {
        return hometown;
    }
    
    public void setHometown(String inf_hometown)
    {
        hometown = inf_hometown;
    }

    //getter and setter methods for highSchool attribute
    public String getHighschool()
    {
        return highSchool;
    }

    public void setHighSchool(String inf_highSchool)
    {
        highSchool = inf_highSchool;
    }

    /*
    overrides Object class to String method. Returns text representation
    of object
    */
    @Override
    public String toString()
    {
        String toString = name + ", " + height + ", " + weight + ", " + 
                hometown + ", " + highSchool;
        return toString;
    }

}
