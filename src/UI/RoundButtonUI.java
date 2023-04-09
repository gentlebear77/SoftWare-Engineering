package UI;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

class RoundButtonUI extends BasicButtonUI {
    private int cornerRadius;

    public RoundButtonUI(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        g.setColor(b.getBackground().darker());
        g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), cornerRadius, cornerRadius);
    }
}

