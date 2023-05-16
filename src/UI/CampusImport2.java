package UI;

import java.awt.*;
import javax.swing.*;

public class CampusImport2 extends JPanel {

    private JButton backButton;
	private JButton exitButton;
    private JButton finishButton;

    public CampusImport2() {
        setLayout(null);

        JLabel nameLabel = new JLabel("Volunteer Activity Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nameLabel.setBounds(82,200,170,25);
        JTextField nameField = new JTextField(15);
        nameField.setBounds(290,200,250,25);

        JLabel yearLabel = new JLabel("Date:");
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        yearLabel.setBounds(210,250,120,25);
        JTextField yearField = new JTextField(15);
        yearField.setBounds(290,250,120,25);

        JLabel durationLabel = new JLabel("Volunteer Duration:");
        durationLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        durationLabel.setBounds(117,300,150,25);
        JTextField durationField = new JTextField(15);
        durationField.setBounds(290,300,120,25);

        finishButton = new JButton("Finish");
        finishButton.setBounds(230,350,100,27);
        finishButton.setContentAreaFilled(false);

        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        add(nameLabel);
        add(nameField);
        add(yearLabel);
        add(yearField);
        add(durationLabel);
        add(durationField);
        add(backButton);
        add(exitButton);
        add(finishButton);
    }

    public JButton getBackButton() {
        return backButton;
    }
    
    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getFinishButton() {
        return finishButton;
    }
    
}
