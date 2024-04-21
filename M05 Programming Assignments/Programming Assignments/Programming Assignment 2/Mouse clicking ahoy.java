import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// JPanel representing a circle that changes color when clicked
public class ColorChangingCircle extends JPanel {

    private Color circleColor = Color.WHITE; // Initial color

    // Constructor
    public ColorChangingCircle() {
        // Add mouse listener to handle mouse events
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                circleColor = Color.BLACK; // Change color to black when mouse is pressed
                repaint(); // Repaint the panel to reflect color change
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                circleColor = Color.WHITE; // Change color back to white when mouse is released
                repaint(); // Repaint the panel to reflect color change
            }
        });
    }

    // Method to paint the circle component
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call superclass method to ensure proper painting
        g.setColor(circleColor); // Set color for the circle
        // Draw oval representing the circle at the center of the panel
        g.fillOval(getWidth()/2 - 50, getHeight()/2 - 50, 100, 100);
    }

    // Main method to create and display the frame containing the ColorChangingCircle panel
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // Create JFrame instance
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        frame.setSize(400, 400); // Set size of the frame
        frame.add(new ColorChangingCircle()); // Add ColorChangingCircle panel to the frame
        frame.setVisible(true); // Make the frame visible
    }
}
