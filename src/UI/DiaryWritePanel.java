package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DiaryWritePanel extends JPanel {
    public DiaryWritePanel(JFrame mainFrame) {
        setBackground(Color.LIGHT_GRAY);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Write");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(titleLabel, gbc);

        JTextArea diaryContentArea = new JTextArea(15, 40);
        diaryContentArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(diaryContentArea);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(scrollPane, gbc);

        JButton saveButton = new JButton("Save");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(saveButton, gbc);

        JButton backButton = new JButton("Back");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(backButton, gbc);
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // back side code of save the written thing

                // back to home page
                mainFrame.setContentPane(new DiaryMainPanel(mainFrame));
                mainFrame.revalidate();
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainFrame.setContentPane(new DiaryMainPanel(mainFrame));
                mainFrame.revalidate();
            }
        });
    }
}
