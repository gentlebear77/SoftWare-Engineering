package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DiaryMainPanel extends JPanel {
    public DiaryMainPanel(JFrame mainFrame) {
        setBackground(Color.LIGHT_GRAY);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("The Input Page");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(titleLabel, gbc);

        JButton writeDiaryButton = new JButton("Write");
        writeDiaryButton.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(writeDiaryButton, gbc);

        JButton viewDiaryListButton = new JButton("open the diary list");
        viewDiaryListButton.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(viewDiaryListButton, gbc);

        JButton backButton = new JButton("Back");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(backButton, gbc);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainFrame.setContentPane(new HomePanel(mainFrame));
                mainFrame.revalidate();
            }
        });
        
        viewDiaryListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new DiaryListPanel(mainFrame));
                mainFrame.revalidate();
            }
        });

        
        writeDiaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new DiaryWritePanel(mainFrame));
                mainFrame.revalidate();
            }
        });
    }

	public DiaryMainPanel() {
		// TODO
	}
    
    
}

