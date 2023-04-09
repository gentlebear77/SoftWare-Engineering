package UI;
import javax.swing.*;
import java.awt.*;

class DiaryMainFrame extends JFrame {
    public DiaryMainFrame() {
        setTitle("Diary Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        //Fix the window size
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int offsetX=(screenSize.width-1200)/2;
		int offsetY=(screenSize.height-800)/2;
		this.setLocation(offsetX, offsetY);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

        setContentPane(new DiaryLoginPanel(this));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DiaryMainFrame frame = new DiaryMainFrame();
            frame.setVisible(true);
        });
    }
}


