package BoundryClass;

import java.awt.*;
import javax.swing.*;

public class InclassImport2 extends JPanel {

    private JButton backButton;
	private JButton exitButton;
    private JButton finishButton;

    JTextField scoreField = new JTextField(15);
    JTextField scoreField2 = new JTextField(15);
    JTextField GPAField = new JTextField(15);
    JTextField rankField = new JTextField(15);

    public InclassImport2() {
        setLayout(null);

        JLabel scoreLabel = new JLabel("Average Score:");
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        scoreLabel.setBounds(190,100,120,25);

        scoreField.setBounds(340,100,120,25);

        JLabel scoreLabel2 = new JLabel("Average Score of Postgraduate:");
        scoreLabel2.setFont(new Font("Arial", Font.PLAIN, 15));
        scoreLabel2.setBounds(76,150,250,25);

        scoreField2.setBounds(340,150,120,25);

        JLabel GPALabel = new JLabel("GPA:");
        GPALabel.setFont(new Font("Arial", Font.PLAIN, 15));
        GPALabel.setBounds(258,200,120,25);

        GPAField.setBounds(340,200,120,25);

        JLabel rankLabel = new JLabel("Rank:");
        rankLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        rankLabel.setBounds(255,250,120,25);

        rankField.setBounds(340,250,200,25);
        

        finishButton = new JButton("Finish");
        finishButton.setBounds(285,300,100,27);
        finishButton.setContentAreaFilled(false);

        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        add(scoreLabel);
        add(scoreField);
        add(scoreLabel2);
        add(scoreField2);
        add(rankLabel);
        add(rankField);
        add(GPALabel);
        add(GPAField);
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

    public String getGPAField() {
        return GPAField.getText();
    }

    public String getRankField() {
        return rankField.getText();
    }

    public String getScoreField() {
        return scoreField.getText();
    }

    public String getScoreField2() {
        return scoreField2.getText();
    }
}