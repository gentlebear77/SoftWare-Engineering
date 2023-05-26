package BoundryClass;

import EntityClass.Student;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GradePanel extends JPanel {
    private JButton exitButton;
    private JButton personButton;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5=new JButton();
    JLabel now = new JLabel("NOW");
    private int grade;
    private int nowLocation;
    private BufferedImage bg;
    public void Update(Student currentUser){
        grade = Integer.parseInt(currentUser.getDegree());
        System.out.println(grade);
        switch(grade) {
            case 1:
                nowLocation = 100;
                break;
            case 2:
                nowLocation = 300;
                break;
            case 3:
                nowLocation = 500;
                break;
            case 4:
                nowLocation = 700;
                break;
        }
        System.out.println(nowLocation);
        button5.setBounds(nowLocation, 370, 70, 70);
        now.setFont(new Font("Arial", Font.BOLD, 15));
        now.setForeground(Color.white);
        now.setBounds(nowLocation+15, 450, 70, 30);
        try {
            Image img = ImageIO.read(getClass().getResource("/images/boat1.png"));
            ImageIcon icon = new ImageIcon(img);
            button5.setIcon(icon);
            icon.setImage(icon.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
            button5.setContentAreaFilled(false);
            button5.setBorderPainted(false);
            button5.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        add(button5);
    }

    public GradePanel() {
        //background
        try {
            bg = ImageIO.read(getClass().getResource("/images/gradebg.jpg"));
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
        button1.setBounds(200, 370, 80, 80);
        try {
            Image img = ImageIO.read(getClass().getResource("/images/land.png"));
            ImageIcon icon1 = new ImageIcon(img);
            button1.setIcon(icon1);
            icon1.setImage(icon1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
            button1.setContentAreaFilled(false);
            button1.setBorderPainted(false);
            button1.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JLabel year1 = new JLabel("Year-1");
        year1.setFont(new Font("Arial", Font.BOLD, 15));
        year1.setForeground(Color.white);
        year1.setBounds(210,450,80,30);

        button2 = new JButton("Year 2");
        button2.setBounds(400, 370, 80, 80);
        try {
            Image img = ImageIO.read(getClass().getResource("/images/land.png"));
            ImageIcon icon2 = new ImageIcon(img);
            button2.setIcon(icon2);
            icon2.setImage(icon2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
            button2.setContentAreaFilled(false);
            button2.setBorderPainted(false);
            button2.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JLabel year2 = new JLabel("Year-2");
        year2.setFont(new Font("Arial", Font.BOLD, 15));
        year2.setForeground(Color.white);
        year2.setBounds(410,450,80,30);

        button3 = new JButton("Year 3");
        button3.setBounds(600, 370, 80, 80);
        try {
            Image img = ImageIO.read(getClass().getResource("/images/land.png"));
            ImageIcon icon3 = new ImageIcon(img);
            button3.setIcon(icon3);
            icon3.setImage(icon3.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
            button3.setContentAreaFilled(false);
            button3.setBorderPainted(false);
            button3.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JLabel year3 = new JLabel("Year-3");
        year3.setFont(new Font("Arial", Font.BOLD, 15));
        year3.setForeground(Color.white);
        year3.setBounds(610,450,80,30);

        button4 = new JButton("Year 4");
        button4.setBounds(800, 280, 120, 180);
        try {
            Image img = ImageIO.read(getClass().getResource("/images/end.png"));
            ImageIcon icon4 = new ImageIcon(img);
            button4.setIcon(icon4);
            icon4.setImage(icon4.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT));
            button4.setContentAreaFilled(false);
            button4.setBorderPainted(false);
            button4.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JLabel year4 = new JLabel("Year-4");
        year4.setFont(new Font("Arial", Font.BOLD, 15));
        year4.setForeground(Color.white);
        year4.setBounds(820,450,80,30);
        System.out.println(nowLocation);

        add(exitButton);
        add(personButton);
        add(titleLabel);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(year1);
        add(year2);
        add(year3);
        add(year4);
        add(now);

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
