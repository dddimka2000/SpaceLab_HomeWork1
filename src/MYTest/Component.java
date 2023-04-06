package MYTest;

import javax.swing.*;
import java.awt.*;

public class Component extends JComponent {
    private int x;
    private int y;
    private Font font;

    public Component(int x, int y, Font font) {
        this.x = x;
        this.y = y;
        this.font = font;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D=(Graphics2D)g;
        g.drawString("My app",x,y);
        g.setFont(font);
    }
}
