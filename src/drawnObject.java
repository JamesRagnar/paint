import java.awt.*;
/**
 *
 * @author Ragnar
 */

public class drawnObject {
    int xPosition, yPosition, xLength, yLength, x0, y0;
    Color color;
    Boolean lock;
    int type;
    //1 = line, 2 = square, 3 = circle
    
    public drawnObject(Point p, Color c, Boolean b, int t) {
        type = t;
        xPosition = p.x;
        yPosition = p.y;
        if(type == 1) {
            xLength = p.x;
            yLength = p.y;
        }
        x0 = p.x;
        y0 = p.y;
        color = c;
        lock = b; 
    }
    public void paint(Graphics g) {
        g.setColor(color);
        if(type == 2) {
            g.drawRect(xPosition, yPosition, xLength, yLength);
        }
        else if(type == 3) {
            g.drawOval(xPosition, yPosition, xLength, yLength);
        }
        else if(type == 1) {
            g.drawLine(xPosition, yPosition, xLength, yLength);
        }
        g.setColor(Color.BLACK);
    }
    
    public void updatePosition(Point p) {
        if(type == 1) {
            xLength = p.x;
            yLength = p.y;
        }
        else if(type == 2 || type == 3) {
            if(p.x >= x0 && p.y >= y0) {
                //object is being drawn in Q4
                xPosition = x0;
                yPosition = y0;
                xLength = p.x - xPosition;
                yLength = p.y - yPosition;
            }
            else if(p.x >= x0 && p.y < y0) {
                //object is being drawn in Q1
                xPosition = x0;
                yPosition = p.y;
                xLength = p.x - x0;
                yLength = y0 - p.y;
            }
            else if(p.x < x0 && p.y >= y0) {
                //object is being drawn in Q3
                xPosition = p.x;
                yPosition = y0;
                xLength = x0 - p.x;
                yLength = p.y - y0;
            }
            else if(p.x < x0 && p.y < y0) {
                //object is being drawn in Q2
                xPosition = p.x;
                yPosition = p.y;
                xLength = x0 - p.x;
                yLength = y0 - p.y;
            }
            if(lock) {
                if(xLength > yLength) {
                    yLength = xLength;
                }
                else {
                    xLength = yLength;
                }
            }
        }
    }
}

