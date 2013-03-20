import java.awt.*;
/**
 *
 * @author Ragnar
 */

public class Line {
    int xPosition, yPosition, xLength, yLength;
    Color color;
    
    public Line(int x, int y, Color c) {
        xPosition = x;
        yPosition = y;
        xLength = x;
        yLength = y;
        color = c;
    }
    public void paint(Graphics g) {
        g.setColor(color);
        g.drawLine(xPosition, yPosition, xLength, yLength);
        g.setColor(Color.BLACK);
    }
    
    public void updatePosition(Point p) {
        xLength = p.x;
        yLength = p.y;
    }
    
    
}

