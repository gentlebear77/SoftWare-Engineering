package BoundryClass;

import java.awt.*;
import javax.swing.*;

public class RegisterPanel extends JPanel {

	private JButton finishButton;
    private JButton backButton;
    private JTextField usernameField;
    private JTextField realnameField;
    private JPasswordField passwordField;
    private JComboBox<String> cgrade;
    private JComboBox<String> cmajor;
    public RegisterPanel() {
        setLayout(null);

        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);

        JLabel titleLabel = new JLabel("Sign up for an account");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        titleLabel.setBounds(100, 140, 475, 40);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameLabel.setBounds(130,220,80,25);
        usernameField = new JTextField(15);
        usernameField.setBounds(230,220,120,25);
        
        JLabel realname = new JLabel("Real name:");
        realname.setFont(new Font("Arial", Font.PLAIN, 15));
        realname.setBounds(130,265,80,30);
        realnameField = new JTextField(15);
        realnameField.setBounds(230,265,120,25);

        JLabel passwordLabel = new JLabel("Keyword:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordLabel.setBounds(140,310,80,30);
        passwordField = new JPasswordField(15);
        passwordField.setBounds(230,310,120,25);

              
		JPanel jgrade = new JPanel(); 
        jgrade.setBounds(25,355,400,40);
        JLabel grade = new JLabel(" Grade:      ");   
        grade.setFont(new Font("Arial", Font.PLAIN, 15));    
        cgrade = new JComboBox<String>();
        cgrade.addItem("1");
        cgrade.addItem("2");
        cgrade.addItem("3");
        cgrade.addItem("4");
        jgrade.add(grade);
        jgrade.add(cgrade);
        
        JPanel jmajor = new JPanel(); 
        jmajor.setBounds(50,400,400,40);
        JLabel major = new JLabel("  Major:      ");
        major.setFont(new Font("Arial", Font.PLAIN, 15));
        cmajor = new JComboBox<String>();
        cmajor.addItem("Telecom");
        cmajor.addItem("IoT ");
        cmajor.addItem("e-Commerce");
        jmajor.add(major);
        jmajor.add(cmajor);

        finishButton = new JButton("Finish");
        finishButton.setBounds(185,460,100,27);
        finishButton.setContentAreaFilled(false);

        add(titleLabel);
        add(usernameLabel);
        add(usernameField);
        add(realname);
        add(realnameField);
        add(passwordLabel);
        add(passwordField);
        add(jgrade);
        add(jmajor);
        add(finishButton);
        add(backButton);
    }

    public JButton getFinishButton() {
        return finishButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public String getUsername(){
        return usernameField.getText();
    }

    public String getRealname(){
        return realnameField.getText();
    }

    public String getPassword(){
        return passwordField.getText();
    }

    public String getGrade(){
        return (String)cgrade.getSelectedItem();
    }

    public String getMajor(){
        return (String)cmajor.getSelectedItem();
    }
}
