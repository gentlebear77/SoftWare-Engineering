package UI;

import javax.swing.border.AbstractBorder;
import java.awt.*;

class RoundedBorder extends AbstractBorder {
    private int cornerRadius;

    public RoundedBorder(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, cornerRadius, cornerRadius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(cornerRadius / 2, cornerRadius / 2, cornerRadius / 2, cornerRadius / 2);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = insets.top = insets.bottom = cornerRadius / 2;
        return insets;
    }
}