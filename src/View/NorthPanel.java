/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * File name: NorthPanel.java
 * Short description: NorthPanel JPanel, houses a search bar
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class NorthPanel extends JPanel
{
    //uninitialized attributes
    JTextField searchBar;
    
    //constructor, builds a JPanel with a searchbar
    public NorthPanel()
    {
        super();
        setBackground(Color.BLACK);
        searchBar = new JTextField("", 15);
        add(searchBar, BorderLayout.CENTER);
    }
    
    //getter and setter for searchBar
    public JTextField getSearchBar()
    {
        return searchBar;
    }
    
    public void setSearchBar(JTextField searchBar)
    {
        this.searchBar = searchBar;
    }
}
