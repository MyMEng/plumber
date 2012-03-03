package plumber;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements MouseListener, MouseMotionListener 
{
    private int size;
    private int dimension;
    private int startPoint;
    private int cellSize;
    
    private Field [][] fields;
    public Board(int width, int height, int size, int dimension)
    {
        this.startPoint = 10;
        this.fields = new Field[dimension][dimension];
        this.setSize(width, height);
        this.size = size;
        this.dimension = dimension;
        cellSize = (size) / (dimension);
        
        for(int i = 0; i < dimension; i++)
        {
            int y = (i > 0) ? cellSize * i + startPoint : startPoint;
            for(int j = 0; j < dimension; j++)
            {
                int p = (j > 0) ? j * cellSize + startPoint : startPoint;
                fields[i][j] = new Field(p, y, cellSize, "bg.png");
                add(fields[i][j]);
            }
        }
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    @Override public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        //paintBoard(g);
        super.paintChildren(g);
    }
    
    public void paintBoard(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        GradientPaint gradient = new GradientPaint(0, 0, Color.LIGHT_GRAY, 
                screenSize.width, screenSize.height, Color.BLACK, true);
        
        Paint prev = g2d.getPaint();
        g2d.setPaint(gradient);
        
        g2d.fillRect(0, 0, screenSize.width, screenSize.height);

        g2d.setPaint(prev);
    }

    @Override public void mouseClicked(MouseEvent e)
    {
        for(Field[] row : fields)
        {
            for(Field cell : row)
            {
                if(cell.contains(e.getX(), e.getY()))
                {
                    cell.changeOpacity(e.getX(), e.getY());
                }
            }
        }
        //super.repaint();
    }

    @Override public void mouseEntered(MouseEvent e)
    {   
    }

    @Override public void mouseExited(MouseEvent e)
    {
    }

    @Override public void mousePressed(MouseEvent e)
    {
    }

    @Override public void mouseReleased(MouseEvent e)
    {
    }

    @Override public void mouseDragged(MouseEvent e)
    { 
    }

    @Override public void mouseMoved(MouseEvent e)
    {
        Point point = e.getPoint();
        for(Field[] row : fields)
        {
            for(Field cell : row)
            {
                cell.setActive(cell.contains(point.x, point.y));
            }
        }
    }
}
