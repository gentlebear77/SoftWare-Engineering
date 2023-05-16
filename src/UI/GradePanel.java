package UI;

import java.awt.*;
import javax.swing.*;

public class GradePanel extends JPanel {
	
	private JButton exitButton;
    private JButton personButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private int grade=2;
    private int nowLocation;

    public GradePanel() {
        setLayout(null);
        
        JLabel titleLabel = new JLabel("Let's Go");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
        titleLabel.setBounds(400,150,300,60);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        personButton = new JButton("Person");//a picture
        personButton.setBounds(800,0,80,30);
        personButton.setContentAreaFilled(false);
        personButton.setBorderPainted(false);

        button1 = new JButton("1");
        button1.setBounds(50, 300, 50, 30);

        button2 = new JButton("2");
        button2.setBounds(250, 300, 50, 30);

        button3 = new JButton("3");
        button3.setBounds(450, 300, 50, 30);

        button4 = new JButton("4");
        button4.setBounds(650, 300, 50, 30);

        switch(grade) {
            case 1:
                nowLocation = 150;
                break;
            case 2:
                nowLocation = 350;
                break;
            case 3:
                nowLocation = 550;
                break;
            case 4:
                nowLocation = 750;
                break;
        }
        button5 = new JButton("Now");
        button5.setBounds(nowLocation, 300, 80, 30);
        
        add(exitButton);
        add(personButton);
        add(titleLabel);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
    }
    
    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getPersonButton() {
        return personButton;
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public JButton getButton5() {
        return button5;
    }
}
