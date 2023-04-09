package UI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DiaryListPanel extends JPanel {
    public DiaryListPanel(JFrame mainFrame) {
        setBackground(Color.LIGHT_GRAY);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Diary List");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(titleLabel, gbc);

        // add some component of adding the diary,just like JList��JTable or self-made component.

        JButton backButton = new JButton("Back");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(backButton, gbc);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new DiaryMainPanel(mainFrame));
                mainFrame.revalidate();
            }
        });
    }
}


