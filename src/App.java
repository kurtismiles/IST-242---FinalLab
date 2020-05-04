
import Controller.Controller;
import Model.Model;
import View.View;

/**
 * File name: App.java
 * Short description: Main method creates model, view, and controller objects
 * IST 242 Assignment: Lesson 6 - Searching a Hash Map
 * @author KURTIS MILES
 * @version 1.01 May 2nd, 2020
 */

class App
{

    //main method of program
    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
    }
}
