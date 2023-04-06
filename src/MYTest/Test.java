package MYTest;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrameStart jFrameStart = new JFrameStart();
        JFrame jFrame=jFrameStart.getJFrameStart();
        Font font=new Font("",Font.ROMAN_BASELINE,14);
        Component component=new Component(jFrameStart.getX()/2,jFrameStart.getY()/2,font);
        jFrame.add(component);
        jFrame.paint(component.getGraphics());
    }
}

