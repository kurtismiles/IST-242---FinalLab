package Model;

import java.util.ArrayList;

/**
 * File name: TableMember.java
 * Short description: Interface with TableMember methods
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public interface TableMember
{

    public String getAttribute(int n);

    public ArrayList<String> getAttributes();

    public String getAttributeName(int n);

    public ArrayList<String> getAttributeNames();
}
