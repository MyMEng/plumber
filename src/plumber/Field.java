package plumber;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class Field extends JComponent
{
    private int size;
    private BufferedImage img;
    private Rectangle imageRect;
    private TexturePaint texturePaint;
    private boolean active;

    public Field(int x, int y, int size, String textureName)
    {
        this.size = size;
        this.active = false;
        img = TextureManager.get(textureName);
        imageRect = new Rectangle(x, y, size, size);
        texturePaint = new TexturePaint(img, imageRect);
    }

    @Override public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(texturePaint);
        
        if(!active)
            g2d.fill(imageRect);
    }
    
    public void setActive(boolean value)
    {
        if(value == active)
            return;
        
        active = value;
        repaint();
    }

    public boolean contains(int x, int y)
    {
        return imageRect.contains((double)x, (double)y);
    }
    public void changeOpacity(int x, int y)
    {
    }
}
