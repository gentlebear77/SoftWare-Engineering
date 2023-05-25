package BoundryClass;

import java.awt.*;
import javax.swing.*;

public class FunctionPanel extends JPanel {
	
	private JButton backButton;
	private JButton exitButton;
	private RoundButton choiceButton1;
	private RoundButton choiceButton2;
	private RoundButton choiceButton3;
	private RoundButton choiceButton4;
	private RoundButton choiceButton5;
	
    public FunctionPanel() {
        setLayout(null);
        
        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        
        JLabel titleLabel = new JLabel("Let's Go");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBounds(400,100,300,60);  
        
        choiceButton1 = new RoundButton("Portfolio",30);
        choiceButton1.setBounds(200,230,120,180);
        choiceButton1.setBackground(new Color(249,220,133));
        choiceButton1.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        choiceButton1.setUI(new PressUI(25) {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(new Color(239, 210, 123));
                g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 15, 15);
            }
        });

        choiceButton2 = new RoundButton("In-Class Learning",30);
        choiceButton2.setBounds(340,180,210,150);
        choiceButton2.setBackground(new Color(198,209,130));
        choiceButton2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        choiceButton2.setUI(new PressUI(25) {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(new Color(188, 199, 120));
                g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 15, 15);
            }
        });
        
        choiceButton3 = new RoundButton("Extra-Class Practice",30);
        choiceButton3.setBounds(340,350,140,100);
        choiceButton3.setBackground(new Color(224,199,227));
        choiceButton3.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        choiceButton3.setUI(new PressUI(25) {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(new Color(214, 189, 217));
                g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 15, 15);
            }
        });
        
        choiceButton4 = new RoundButton("Export Data",30);
        choiceButton4.setBounds(570,250,120,80);
        choiceButton4.setBackground(new Color(157,194,222));
        choiceButton4.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        choiceButton4.setUI(new PressUI(25) {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(new Color(147, 184, 212));
                g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 15, 15);
            }
        });
        
        choiceButton5 = new RoundButton("Campus Life",30);
        choiceButton5.setBounds(500,350,190,130);
        choiceButton5.setBackground(new Color(242,211,191));
        choiceButton5.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        choiceButton5.setUI(new PressUI(25) {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(new Color(232, 201, 181));
                g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 15, 15);
            }
        });
  
        add(backButton);
        add(exitButton);
        add(titleLabel);
        add(choiceButton1);
        add(choiceButton2);
        add(choiceButton3);
        add(choiceButton4);
        add(choiceButton5);
    }

    public JButton getBackButton() {
        return backButton;
    }
    
    public JButton getExitButton() {
        return exitButton;
    }
    
    public JButton getChoiceButton1() {
        return choiceButton1;
    }

    public JButton getChoiceButton2() {
        return choiceButton2;
    }

    public JButton getChoiceButton3() {
        return choiceButton3;
    }

    public JButton getChoiceButton4() {
        return choiceButton4;
    }

    public JButton getChoiceButton5() {
        return choiceButton5;
    }
}