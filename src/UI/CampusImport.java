package UI;

import java.awt.*;
import javax.swing.*;


public class CampusImport extends JPanel {

    private JButton backButton;
	private JButton exitButton;
    private JButton finishButton;

    JTextField nameField = new JTextField(15);
    JTextField yearField = new JTextField(15);

    public CampusImport() {
        setLayout(null);

        JLabel nameLabel = new JLabel("Student Work Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nameLabel.setBounds(106,200,150,25);

        nameField.setBounds(290,200,250,25);


        JLabel yearLabel = new JLabel("Date:");
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        yearLabel.setBounds(210,250,120,25);

        yearField.setBounds(290,250,120,25);

        finishButton = new JButton("Finish");
        finishButton.setBounds(230,300,100,27);
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

    public String getNameField() {
        Control_check cc=new Control_check();
        return cc.check_empty(nameField);
    }

    public String getYearField() {
        Control_check cc=new Control_check();
        return cc.check_year(yearField);
    }

}
