package UI;

import java.awt.*;
import javax.swing.*;

public class ExtraImport1 extends JPanel {

    private JButton backButton;
	private JButton exitButton;
    private JButton finishButton;

    public ExtraImport1() {
        setLayout(null);

        JLabel nameLabel = new JLabel("Project Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nameLabel.setBounds(100,150,120,25);
        JTextField nameField = new JTextField(15);
        nameField.setBounds(240,150,200,25);


        JLabel yearLabel = new JLabel("Date:");
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        yearLabel.setBounds(160,200,120,25);
        JTextField yearField = new JTextField(15);
        yearField.setBounds(240,200,120,25);

        JLabel contentLabel = new JLabel("Project Content:");
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        contentLabel.setBounds(90,250,120,25);
        JTextArea contentField = new JTextArea();
        contentField.setBounds(240,250,400,100);

        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        finishButton = new JButton("Finish");
        finishButton.setBounds(200,400,100,27);
        finishButton.setContentAreaFilled(false);

        add(nameLabel);
        add(nameField);
        add(yearLabel);
        add(yearField);
        add(contentLabel);
        add(contentField);
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