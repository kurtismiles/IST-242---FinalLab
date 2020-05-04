package Model;

/**
 * File name: Displayable.java
 * Short description: Interface with Displayable methods
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public interface Displayable
{
    
    public int getFirstLineToDisplay();
    
    public int getLineToHighlight();
    
    public int getLastLineToDisplay();
    
    public int getLinesBeingDisplayed();

    public void setFirstLineToDisplay(int firstLine);
    
    public void setLineToHighlight(int highlightedLine);
    
    public void setLastLineToDisplay(int lastLine);
    
    public void setLinesBeingDisplayed(int numberOfLines);
}
