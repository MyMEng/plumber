package plumber;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class Field
{
    private int x;
    private int y;
    private int size;
    private BufferedImage img;

    public Field(int x, int y, int size, String textureName)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        URL u = null;
        try
        {
            u = this.getClass().getResource("gfx/" + textureName);
            this.img = ImageIO.read(u);
        }
        catch(Exception ex)
        {
            System.err.print(u);
            throw new Error("Error while reading from a file: " + ex.getMessage());
        }
    }

    public void draw(Graphics2D g)
    {
        
        g.drawImage(img, x, y, size, size, null);
    }
}
