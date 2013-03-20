import java.awt.*;
/**
 *
 * @author Ragnar
 */

public class Rectangle {
    int xPosition, yPosition, xLength, yLength, x0, y0;
    Color color;
    Boolean square;
    
    public Rectangle(int x, int y, Color c, Boolean b) {
        xPosition = x;
        yPosition = y;
        x0 = x;
        y0 = y;
        color = c;
        square = b;
    }
    public void paint(Graphics g) {
        g.setColor(color);
        g.drawRect(xPosition, yPosition, xLength, yLength);
        g.setColor(Color.BLACK);
    }
    
    public void updatePosition(Point p) {
        if(p.x >= x0 && p.y >= y0) {
            //rectangle is being drawn in Q4
            xPosition = x0;
            yPosition = y0;
            xLength = p.x - xPosition;
            yLength = p.y - yPosition;
        }
        else if(p.x >= x0 && p.y < y0) {
            //rectangle is being drawn in Q1
            xPosition = x0;
            yPosition = p.y;
            xLength = p.x - x0;
            yLength = y0 - p.y;
        }
        else if(p.x < x0 && p.y >= y0) {
            //rectangle is being drawn in Q3
            xPosition = p.x;
            yPosition = y0;
            xLength = x0 - p.x;
            yLength = p.y - y0;
        }
        else if(p.x < x0 && p.y < y0) {
            //rectange is being drawn in Q2
            xPosition = p.x;
            yPosition = p.y;
            xLength = x0 - p.x;
            yLength = y0 - p.y;
        }
        if(square) {
            if(xLength > yLength) {
                yLength = xLength;
            }
            else {
                xLength = yLength;
            }
        }
    }
}

