import java.awt.*;
/**
 *
 * @author Ragnar
 */

public class Circle {
    int xPosition, yPosition, xLength, yLength, x0, y0;
    Color color;
    Boolean circle;
    
    public Circle(int x, int y, Color c, Boolean b) {
        xPosition = x;
        yPosition = y;
        x0 = x;
        y0 = y;
        color = c;
        circle = b;
    }
    public void paint(Graphics g) {
        g.setColor(color);
        g.drawOval(xPosition, yPosition, xLength, yLength);
        g.setColor(Color.BLACK);
    }
    
    public void updatePosition(Point p) {
        if(p.x >= x0 && p.y >= y0) {
            //circle is being drawn in Q4
            xPosition = x0;
            yPosition = y0;
            xLength = p.x - xPosition;
            yLength = p.y - yPosition;
        }
        else if(p.x >= x0 && p.y < y0) {
            //circle is being drawn in Q1
            xPosition = x0;
            yPosition = p.y;
            xLength = p.x - x0;
            yLength = y0 - p.y;
        }
        else if(p.x < x0 && p.y >= y0) {
            //circle is being drawn in Q3
            xPosition = p.x;
            yPosition = y0;
            xLength = x0 - p.x;
            yLength = p.y - y0;
        }
        else if(p.x < x0 && p.y < y0) {
            //circle is being drawn in Q2
            xPosition = p.x;
            yPosition = p.y;
            xLength = x0 - p.x;
            yLength = y0 - p.y;
        }
        if(circle) {
            if(xLength > yLength) {
                yLength = xLength;
            }
            else {
                xLength = yLength;
            }
        }
    }
    
    
}

