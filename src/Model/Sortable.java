package Model;

/**
 * File name: Sortable.java
 * Short description: Interface with Sortable methods
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public interface Sortable
{
    
  public void sort(int sortType, int sortField);
  
  public int getSortType();
  
  public void setSortType(int sortType);
  
  public int getSortField();
  
  public void setSortField(int sortField);
}
