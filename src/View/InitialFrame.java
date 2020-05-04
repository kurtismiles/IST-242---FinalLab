package View;

import javax.swing.*;

/**
 * File name: InitialFrame.java
 * Short description: JFrame InitialFrame object that houses an InitialPanel 
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class InitialFrame extends JFrame
{ 
    //uninitialized attributes
    private InitialPanel ip;
    
    //constructor
    public InitialFrame()
    {
        super("A04C - Graphics, Data, and Interfaces with MVC");
        setupLayoutForMacs();
        ip = new InitialPanel();
        add(ip, "Center");
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
    }

    private void setupLayoutForMacs()
    {
        //On some MACs it might be necessary to have the statement below 
        //for the background color of the button to appear    
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        //------------------------------------------------------
    }

    //getter and setter for ip
    public InitialPanel getIp()
    {
        return ip;
    }

    public void setIp(InitialPanel ip)
    {
        this.ip = ip;
    }
}
