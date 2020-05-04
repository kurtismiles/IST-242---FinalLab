package Controller;

import Model.Model;
import View.View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;

/**
 * File name: Controller.java
 * Short description: Uses model and view to display data about FootballPlayer objects
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

public class Controller
{

    //class attributes
    private Model model;
    private View view;

    //constructor
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
        view.CenterInitialSetup(model.getFpData().getLinesBeingDisplayed(),
                model.getFpData().getHeaders().size());
        view.CenterUpdate(
                model.getFpData().getLines(
                        model.getFpData().getFirstLineToDisplay(),
                        model.getFpData().getLastLineToDisplay()),
                model.getFpData().getHeaders());
        addListeners();
    }

    //getter and setter methods for model
    public Model getModel()
    {
        return this.model;
    }

    public void setModel(Model inf_model)
    {
        this.model = inf_model;
    }

    //getter and setter methods for view
    public View getView()
    {
        return view;
    }

    public void setView(View inf_view)
    {
        this.view = inf_view;
    }

    //method to add various listeners to view using inner listener
    private void addListeners()
    {
        /*
        Adds MouseWheelListener to centerPanel that scrolls array data.
        The if statement checks if scroll is out of bounds. If it is out
        of bounds the statement will do nothing. When the scroll is within 
        bounds the else statement will update model fpData with new
        first and last line based on units scrolled then update the CP
        and validate/repaint the panel. 
                
        *note*
        Using e.getUnitsToScroll as suggested in the lesson might cut
        off the end of the array as it increments and deincrements by 3
        in my case (this variable might differ for others too and cause
        similar problems). A value of 3 also causes the table to scroll
        rather quickly 3 units at a time. This could be changed to only
        increment the table by 1 at a time in either direction but I
        opted to complete this how the lesson suggested by adding units
        to scroll to the first and last line. I assume this is because
        getUnitsToScroll is meant to scroll pixels (and returns an appropriate
        value based on OS) instead of array values.
         */
        view.getMf().getIp().getCp().addMouseWheelListener(
                new MouseWheelListener()
                {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                //if the scroll is out of bounds
                if (((e.getUnitsToScroll() < 0) && ((model.getFpData().getFirstLineToDisplay() + e.getUnitsToScroll()) < 0))
                        || ((e.getUnitsToScroll() > 0) && ((model.getFpData().getLastLineToDisplay() + e.getUnitsToScroll())
                        > (model.getFpData().getTable().size() - 1))))
                //do nothing    
                {}
                
                //else the scroll is inbounds 
                else
                {
                    //update lines to display based on scroll and update CenterPanel
                    model.getFpData().setFirstLineToDisplay(model.getFpData().getFirstLineToDisplay() + e.getUnitsToScroll());
                    model.getFpData().setLastLineToDisplay(model.getFpData().getLastLineToDisplay() + e.getUnitsToScroll());
                    view.CenterUpdate(
                            model.getFpData().getLines(
                                    model.getFpData().getFirstLineToDisplay(),
                                    model.getFpData().getLastLineToDisplay()),
                            model.getFpData().getHeaders());

                    /*
                    if a search was performed and a row needs to be highlighted
                    clear everything else and rehighlight new row
                    */
                    if (model.getFpData().getLineToHighlight() != -1)
                    {
                        clearRows();
                        highLightRow();
                    }
                }
            }
        });

        /*
        Adds actionListener to labelArray buttons in CP.
        If label button`s background is light gray flip it to dark gray
        and then reset all other buttons so none of them are dark gray
        too. Stores which button is clicked in sortField variable then
        sorts the data if the sortType was chosen before. If label buttons
        background is already dark gray then reset this button,
        the sortField variable, and model so that sorts are undone.
         */
        for (int i = 0; i < view.getMf().getIp().getCp().getLabelArray().size(); ++i)
        {
            int arrayPosition = i;
            view.getMf().getIp().getCp().getLabelArray().get(i).addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    //if a button is unpressed highlight it and possibly sort
                    if (view.getMf().getIp().getCp().getLabelArray().get(arrayPosition).getBackground() == Color.LIGHT_GRAY)
                    {
                        view.getMf().getIp().getCp().getLabelArray().get(arrayPosition).setBackground(Color.DARK_GRAY);
                        view.getMf().getIp().getCp().getLabelArray().get(arrayPosition).setForeground(Color.WHITE);

                        model.getFpData().setSortField(arrayPosition);

                        //if a sort type is chosen carry out a search and update
                        if (model.getFpData().getSortType() != -1)
                        {
                            model.getFpData().sort(model.getFpData().getSortType(), model.getFpData().getSortField());
                            view.CenterUpdate(
                                    model.getFpData().getLines(
                                            model.getFpData().getFirstLineToDisplay(),
                                            model.getFpData().getLastLineToDisplay()),
                                    model.getFpData().getHeaders());

                            //reset all button colors and clear previous search
                            //prevents the previous search from appearing in new sort
                            clearRows();
                            resetSearch();
                        }

                        //reset the text and background of all other labels
                        for (int j = 0; j < view.getMf().getIp().getCp().getLabelArray().size(); ++j)
                        {
                            if (arrayPosition != j) {
                                view.getMf().getIp().getCp().getLabelArray().get(j).setBackground(Color.LIGHT_GRAY);
                                view.getMf().getIp().getCp().getLabelArray().get(j).setForeground(Color.BLACK);
                            }
                        }           
                    } 
                    //if the button is already pressed reset everything
                    else if (view.getMf().getIp().getCp().getLabelArray().get(arrayPosition).getBackground() == Color.DARK_GRAY)
                    {
                        view.getMf().getIp().getCp().getLabelArray().get(arrayPosition).setBackground(Color.LIGHT_GRAY);
                        view.getMf().getIp().getCp().getLabelArray().get(arrayPosition).setForeground(Color.BLACK);

                        int temp = model.getFpData().getSortType();
                        model = new Model();
                        model.getFpData().setSortType(temp);
                        view.CenterUpdate(
                                model.getFpData().getLines(
                                        model.getFpData().getFirstLineToDisplay(),
                                        model.getFpData().getLastLineToDisplay()),
                                model.getFpData().getHeaders());
                        clearRows();
                        resetSearch();
                    }
                }
            });
        }

        /*
        Adds actionlistener to WestPanel buttons and manipulates sortType
        based on button chosen. If button is clicked it will change button
        background and store which button clicked in sortType variable while
        resetting all other buttons. If a clicked button is clicked again it
        will reset the background and sortType. 
         */
        for (int i = 0; i < view.getMf().getIp().getWp().getButtonArray().size(); ++i)
        {
            int arrayPosition = i;
            view.getMf().getIp().getWp().getButtonArray().get(i).addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (view.getMf().getIp().getWp().getButtonArray().get(arrayPosition).getBackground() == new JButton().getBackground())
                    {
                        view.getMf().getIp().getWp().getButtonArray().get(arrayPosition).setBackground(Color.darkGray);
                        view.getMf().getIp().getWp().getButtonArray().get(arrayPosition).setForeground(Color.white);
                        model.getFpData().setSortType(arrayPosition);

                        for (int j = 0; j < view.getMf().getIp().getWp().getButtonArray().size(); ++j)
                        {
                            if (arrayPosition != j)
                            {
                                view.getMf().getIp().getWp().getButtonArray().get(j).setBackground(new JButton().getBackground());
                                view.getMf().getIp().getWp().getButtonArray().get(j).setForeground(new JButton().getForeground());
                            }
                        }
                    } 
                    else if (view.getMf().getIp().getWp().getButtonArray().get(arrayPosition).getBackground() != new JButton().getBackground())
                    {
                        view.getMf().getIp().getWp().getButtonArray().get(arrayPosition).setBackground(new JButton().getBackground());
                        view.getMf().getIp().getWp().getButtonArray().get(arrayPosition).setForeground(new JButton().getForeground());

                        model.getFpData().setSortType(-1);
                    }
                }
            });
        }

        /*
        Adds listener for enter key. Checks to see if a column is selected and 
        then searches for that string in that column using searchable interface 
        in FootballPlayerData. If a column is selected a search can be done
        in that column regardless of the table being sorted or not. If a search
        does not find anything it will turn the search bar red until a proper
        search is done. Resorting the table for another column or resetting the
        column in use will reset everything too.
         */
        view.getMf().getIp().getNp().getSearchBar().addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                if (e.getKeyChar() == KeyEvent.VK_ENTER)
                {
                    //first check if a sortType is chosen
                    if (model.getFpData().getSortField() != -1)
                    {
                        //change fieldIndex to sortField variable so that a search can be performed
                        model.getFpData().setSearchByField(model.getFpData().getSortField());

                        //if the search term is found
                        if (model.getFpData().search(view.getMf().getIp().getNp().getSearchBar().getText()))
                        {
                            view.getMf().getIp().getNp().getSearchBar().setBackground(Color.white);
                            model.getFpData().setLineToHighlight(model.getFpData().getFoundIndex());

                            //if the row to highlight can be placed at the top
                            if ((model.getFpData().getLineToHighlight() + 19) < model.getFpData().getTable().size())
                            {
                                model.getFpData().setFirstLineToDisplay(model.getFpData().getLineToHighlight());
                                model.getFpData().setLastLineToDisplay(model.getFpData().getLineToHighlight() + 19);
                            } 
                            //else the row to highlight cannot be placed at the top
                            else
                            {
                                model.getFpData().setFirstLineToDisplay(model.getFpData().getTable().size() - 20);
                                model.getFpData().setLastLineToDisplay(model.getFpData().getTable().size() - 1);
                            }

                            //update position of window
                            view.CenterUpdate(
                                    model.getFpData().getLines(
                                            model.getFpData().getFirstLineToDisplay(),
                                            model.getFpData().getLastLineToDisplay()),
                                    model.getFpData().getHeaders());

                            //clear anything else highlighted and then highlight current search
                            clearRows();
                            highLightRow();
                        } 
                        //if the search term is not found turn searchbar red
                        else
                        {
                            view.getMf().getIp().getNp().getSearchBar().setOpaque(true);
                            view.getMf().getIp().getNp().getSearchBar().setBackground(Color.red);
                        }

                    }

                }
            }
            //not used
            @Override
            public void keyPressed(KeyEvent e)
            {
            }
            //not used
            @Override
            public void keyReleased(KeyEvent e)
            {
            }
        });
    }

    /*
    Checks if button shown in Cp has the same text as the player at highlighted
    line and then highlights that row of buttons if true. Only checks the column
    based on chosen sortField.
     */
    public void highLightRow()
    {
        for (int i = 0; i < view.getMf().getIp().getCp().getButtonArrayArray().size(); ++i)
        {
            if (view.getMf().getIp().getCp().getButtonArrayArray().get(i).get(model.getFpData().getSortField())
                    .getText().equals(model.getFpData().getTable().get(model.getFpData().getLineToHighlight())
                            .getAttribute(model.getFpData().getSortField())))
            {
                for (int j = 0; j < view.getMf().getIp().getCp().getButtonArrayArray().get(i).size(); ++j)
                {
                    view.getMf().getIp().getCp().getButtonArrayArray().get(i).get(j).setBackground(Color.red);
                }
            }
        }
    }

    //Resets the background color of all buttons on screen.
    public void clearRows()
    {
        for (int i = 0; i < view.getMf().getIp().getCp().getButtonArrayArray().size(); ++i)
        {
            for (int j = 0; j < view.getMf().getIp().getCp().getButtonArrayArray().get(i).size(); ++j)
            {
                view.getMf().getIp().getCp().getButtonArrayArray().get(i).get(j)
                        .setBackground(new JButton().getBackground());
            }
        }
    }

    //Resets all attributes used to search and resets the searchbar
    public void resetSearch()
    {
        model.getFpData().setLineToHighlight(-1);
        model.getFpData().setFoundIndex(-1);
        model.getFpData().setSearchByField(-1);
        view.getMf().getIp().getNp().getSearchBar().setText("");
        view.getMf().getIp().getNp().getSearchBar().setBackground(Color.white);
    }
}
