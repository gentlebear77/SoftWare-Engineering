package UI;

import java.awt.*;
import javax.swing.*;

public class InclassImport extends JPanel {

    private JButton backButton;
	private JButton exitButton;
    private JButton finishButton;

    public InclassImport() {
        setLayout(null);

        JLabel numberLabel = new JLabel("Module Number:");
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        numberLabel.setBounds(90,100,120,25);
        JTextField numberField = new JTextField(15);
        numberField.setBounds(240,100,120,25);

        JLabel nameLabel = new JLabel("Module Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nameLabel.setBounds(100,150,120,25);
        JTextField nameField = new JTextField(15);
        nameField.setBounds(240,150,200,25);

        JPanel jgrade = new JPanel(); 
        jgrade.setBounds(30,195,400,40);
        JLabel grade = new JLabel(" Grade:          ");   
        grade.setFont(new Font("Arial", Font.PLAIN, 15));    
        JComboBox<String> cgrade = new JComboBox<String>();
        cgrade.addItem("      1     ");
        cgrade.addItem("      2     ");
        cgrade.addItem("      3     ");
        cgrade.addItem("      4     ");
        jgrade.add(grade);
        jgrade.add(cgrade);

        JLabel creditLabel = new JLabel("Credit:");
        creditLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        creditLabel.setBounds(150,250,120,25);
        JTextField creditField = new JTextField(15);
        creditField.setBounds(240,250,120,25);

        JLabel markLabel = new JLabel("Mark:");
        markLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        markLabel.setBounds(156,300,120,25);
        JTextField markField = new JTextField(15);
        markField.setBounds(240,300,120,25);

        finishButton = new JButton("Finish");
        finishButton.setBounds(185,350,100,27);
        finishButton.setContentAreaFilled(false);

        backButton = new JButton("back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        add(numberLabel);
        add(numberField);
        add(nameLabel);
        add(nameField);
        add(jgrade);
        add(creditLabel);
        add(creditField);
        add(markLabel);
        add(markField);
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