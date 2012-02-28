package plumber;

import java.awt.*;
import javax.swing.*;

public class Game 
{
    /**
     * @param args Arguments to the program - can be ignored
     */
    public static void main(String[] args) 
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(800, 600));
        panel.add(new Label("Hello world!"));
        panel.setVisible(true);
        //new branch test
    }
}
