package MYTest;

import javax.swing.*;
import java.awt.*;

public class JFrameStart {
    private JFrame jFrame = new JFrame();
    private int x = 500;
    private int y = 400;
    private String title="My App";
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension dimension = toolkit.getScreenSize();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    JFrame getJFrameStart() {
        jFrame.getContentPane();
        jFrame.setTitle(title);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(x, y);
        jFrame.setLocation((dimension.width - x) / 2, (dimension.height - y) / 2);
        return jFrame;
    }
}
