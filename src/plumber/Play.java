package plumber;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Play implements Runnable
{
    private JFrame frame;
    private JPanel panel;
    private final int width = 1000;
    private final int height = 700;
    private final String windowTitle = "Plumber";
    /**
     * Initialize windows etc.
     */
    public Play()
    {
        panel = new Board(width, height, (int)(0.9 * height), 15);
        frame = new JFrame(windowTitle);
        // End process correctly
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(panel);
        
    }

    /**
     * Run the game
     */
    public void run()
    {       
        frame.setSize(width, height);
        //frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * @param args Arguments to the program - can be ignored
     */
    public static void main(String[] args) 
    {
        Play play = new Play();
        SwingUtilities.invokeLater(play);
    }
}
