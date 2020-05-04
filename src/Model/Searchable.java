package Model;

/**
 * File name: Searchable.java
 * Short description: Interface with Searchable methods
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public interface Searchable
{

    public boolean search(String searchTerm);

    public int getFoundIndex();

    public void setFoundIndex(int tableMemberindex);

    public boolean getFound();

    public void setFound(boolean searchResult);

    public int getSearchByField();

    public void setSearchByField(int fieldIndex);
}
