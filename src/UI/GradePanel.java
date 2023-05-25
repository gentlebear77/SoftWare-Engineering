package UI;

import java.awt.*;
import javax.swing.*;
import Control.Student;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import Control.*;

public class GradePanel extends JPanel {
	
	private JButton exitButton;
    private JButton personButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5= new JButton("NOW");;
    private int grade;
    private int nowLocation;
    private BufferedImage bg;
    public void Update(Student currentUser){
        grade = Integer.parseInt(currentUser.getDegree());
        System.out.println(grade);
        switch(grade) {
            case 1:
                nowLocation = 30;
                break;
            case 2:
                nowLocation = 225;
                break;
            case 3:
                nowLocation = 425;
                break;
            case 4:
                nowLocation = 625;
                break;
        }
        System.out.println(nowLocation);
        //button5 = new JButton("NOW");
        button5.setBounds(nowLocation, 425, 70, 30);
        add(button5);
    }

    public GradePanel() {
        //background
        try {
            bg = ImageIO.read(getClass().getResource("/images/gradepanel.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);


        JLabel titleLabel = new JLabel("Let's Go");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
        titleLabel.setBounds(350,150,300,60);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        personButton = new JButton("Person");//a picture
        personButton.setBounds(800,0,80,30);
        personButton.setContentAreaFilled(false);
        personButton.setBorderPainted(false);

        button1 = new JButton("Year 1");
        button1.setBounds(120, 425, 80, 30);

        button2 = new JButton("Year 2");
        button2.setBounds(320, 425, 80, 30);

        button3 = new JButton("Year 3");
        button3.setBounds(520, 425, 80, 30);

        button4 = new JButton("Year 4");
        button4.setBounds(720, 425, 80, 30);
        System.out.println(nowLocation);

//        ImageIcon icon = new ImageIcon("/images/boat.png");
//        icon.setImage(icon.getImage().getScaledInstance(100,100, 0));

//        button5.setIcon(icon);
//        // 设置按钮的首选大小
//        button5.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
//        // 设置按钮的位置和大小
//        button5.setBounds(50, 50, icon.getIconWidth(), icon.getIconHeight());
        //button5 = new JButton("NOW");

        
        add(exitButton);
        add(personButton);
        add(titleLabel);
        add(button1);
        add(button2);
        add(button3);
        add(button4);

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
    //background
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw image
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
