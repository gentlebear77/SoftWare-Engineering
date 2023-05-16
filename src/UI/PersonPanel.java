package UI;

import java.awt.*;
import javax.swing.*;

public class PersonPanel extends JPanel {

    private JButton backButton;
	private JButton exitButton;

    public PersonPanel() {
        setLayout(null);

        JLabel titleLabel = new JLabel("Personal Information");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        titleLabel.setBounds(350, 100, 475, 40);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameLabel.setBounds(380,220,80,25);
        JLabel usernameLabel2 = new JLabel("AAAAA");
        usernameLabel2.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameLabel2.setBounds(480,220,120,25);
        
        JLabel realnameLabel = new JLabel("Real name:");
        realnameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        realnameLabel.setBounds(379,280,80,30);
        JLabel realnameLabel2 = new JLabel("BBBBB");
        realnameLabel2.setFont(new Font("Arial", Font.PLAIN, 15));
        realnameLabel2.setBounds(480,280,120,25);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        gradeLabel.setBounds(407,340,80,30);
        JLabel gradeLabel2 = new JLabel("3");
        gradeLabel2.setFont(new Font("Arial", Font.PLAIN, 15));
        gradeLabel2.setBounds(480,340,120,25);

        JLabel majorLabel = new JLabel("Major:");
        majorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        majorLabel.setBounds(412,400,80,30);
        JLabel majorLabel2 = new JLabel("DDDDD");
        majorLabel2.setFont(new Font("Arial", Font.PLAIN, 15));
        majorLabel2.setBounds(480,400,120,25);

        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        add(titleLabel);
        add(usernameLabel);
        add(usernameLabel2);
        add(realnameLabel);
        add(realnameLabel2);
        add(gradeLabel);
        add(gradeLabel2);
        add(majorLabel);
        add(majorLabel2);
        add(backButton);
        add(exitButton);
    }

    public JButton getBackButton() {
        return backButton;
    }
    
    public JButton getExitButton() {
        return exitButton;
    }
    
}
