package View;

import java.awt.*;
import javax.swing.*;

/**
 * File name: InitialPanel.java
 * Short description: JPanel InitialPanel that houses CenterPanel
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class InitialPanel extends JPanel
{ 
    //uninitialized attributes
    private CenterPanel CenterPanel;
    private WestPanel WestPanel;
    private NorthPanel NorthPanel;
    
    //constructor
    public InitialPanel()
    {
        super();
   
        //setting borderLayout for this panel makes the CenterPanel resizable
        setLayout(new BorderLayout());
        
        CenterPanel = new CenterPanel();
        WestPanel = new WestPanel();
        NorthPanel = new NorthPanel();
        
        add(CenterPanel, BorderLayout.CENTER);
        add(WestPanel, BorderLayout.WEST);
        add(NorthPanel, BorderLayout.NORTH);
    }
    
    //getter and setter methods for CenterPanel
    public CenterPanel getCp()
    {
        return CenterPanel;
    }

    public void setCp(CenterPanel CenterPanel)
    {
        this.CenterPanel = CenterPanel;
    }
    
    //getter and setter methods for WestPanel
    public WestPanel getWp()
    {
        return WestPanel;
    }
    
    public void setWp(WestPanel WestPanel)
    {
        this.WestPanel = WestPanel;
    }
    
    public NorthPanel getNp()
    {
        return NorthPanel;
    }
    
    public void setNp(NorthPanel NorthPanel)
    {
        this.NorthPanel = NorthPanel;
    }
}
