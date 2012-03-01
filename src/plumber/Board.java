package plumber;

import java.awt.*;

public class Board extends Canvas
{
    private int size;
    private int dimension;
    private int startPoint;
    
    public Board(int size, int dimension)
    {
        this.startPoint = 10;
        this.size = size;
        this.dimension = dimension;
        setSize(size, size);
        setBackground(Color.BLACK);
    }
    
    public void paint(Graphics g)
    {
        Graphics2D gd = (Graphics2D)g;
        gd.setColor(Color.WHITE);

        int cellSize = (size) / (dimension);
        int length = ((cellSize) * (dimension));
        for(int i = 0; i <= dimension; i++)
        {
            int y1 = (i > 0) ? i * cellSize + startPoint : startPoint;
            y1 = (i >= dimension) ? i * cellSize : y1;
            gd.drawLine(startPoint, y1, length, y1 );
            gd.drawLine(y1, startPoint, y1, length);
        }
    }
}
