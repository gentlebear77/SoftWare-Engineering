package UI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
	public HomePanel(JFrame mainFrame) {
        setBackground(Color.LIGHT_GRAY);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Choose page");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(titleLabel, gbc);
        

        JButton choiceButton1 = new JButton("In-class learning");
        choiceButton1.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(choiceButton1, gbc);

        JButton choiceButton2 = new JButton("Extra-class practice");
        choiceButton2.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(choiceButton2, gbc);
        
        JButton choiceButton3 = new JButton("Campus life");
        choiceButton3.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(choiceButton3, gbc);
        
        JButton logoutButton = new JButton("Log out");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(logoutButton, gbc);

        

        choiceButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//new page
                //mainFrame.setContentPane(new DiaryListPanel(mainFrame));
                //mainFrame.revalidate();
            }
        });

        
        choiceButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//new page
                //mainFrame.setContentPane(new DiaryWritePanel(mainFrame));
                //mainFrame.revalidate();
            }
        });
        
        
        choiceButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	mainFrame.setContentPane(new DiaryMainPanel(mainFrame));
            	mainFrame.revalidate();
            }
        });
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new DiaryLoginPanel(mainFrame));
                mainFrame.revalidate();
            }
        });
        
        

    }

}
