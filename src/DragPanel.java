import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragPanel extends JPanel{
    
    ImageIcon image = new ImageIcon("src/smile.png");
    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point prevPoint;

    DragPanel() {
        imageCorner = new Point(0,0);
        System.out.println(image.getIconWidth());
        System.out.println(imageCorner);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
        this.setBackground(Color.DARK_GRAY);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
    }

    private class ClickListener extends MouseAdapter {
    
        public void mousePressed(MouseEvent e) {
            prevPoint = e.getPoint();
        }
        
    }

    private class DragListener extends MouseMotionAdapter {
        
        public void mouseDragged(MouseEvent e) {
            Point currPoint = e.getPoint();

            imageCorner.translate(
                (int)(currPoint.getX() - prevPoint.getX()),
                (int)(currPoint.getY() - prevPoint.getY())
            );
            prevPoint = currPoint;
            repaint();
        }
        
    }
}
