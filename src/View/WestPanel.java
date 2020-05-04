package View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * File name: WestPanel.java
 * Short description: WestPanel JPanel, houses buttons for choosing sortType
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class WestPanel extends JPanel
{
    //uninitallized attributes
    private JLabel text1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
      
    private ArrayList<JButton> buttonArray;
     
    //contructor
    public WestPanel()
    {
        super();
        setLayout(new GridLayout(4, 0, 0, 5));
        setBackground(Color.DARK_GRAY);
         
        text1 = new JLabel("Choose a SORT Type");
        text1.setForeground(Color.WHITE);
        
        button1 = new JButton("(1)Selection/Write Yourself");
        button2 = new JButton("(2)Merge/ArrayList()");
        button3 = new JButton("(3)Quick/Arrays[]");
        
        buttonArray = new ArrayList<>(3);
        buttonArray.add(button1);
        buttonArray.add(button2);
        buttonArray.add(button3);
        
        add(text1);
        add(button1);
        add(button2);
        add(button3);          
    }
    
    //getter and setter for buttonArray
    public void setButtonArray(ArrayList<JButton> buttonArray)
    {
        this.buttonArray = buttonArray;
    }
    
    public ArrayList<JButton> getButtonArray()
    {
        return buttonArray;
    }
    
    //getter and setter for button1
    public void setButton1(JButton button1)
    {
        this.button1 = button1;
    }
    
    public JButton getButton1()
    {
        return button1;
    }
    
    //getter and setter for button2
    public void setButton2(JButton button2)
    {
        this.button2 = button2;
    }
    
    public JButton getButton2()
    {
        return button2;
    }
    
    //getter and setter for button3
    public void setButton3(JButton button3)
    {
        this.button3 = button3;
    }
    
    public JButton getButton3()
    {
        return button3;
    }
}
