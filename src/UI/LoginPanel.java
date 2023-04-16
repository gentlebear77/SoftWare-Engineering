package UI;

import java.awt.*;
import javax.swing.*;


public class LoginPanel extends JPanel{

    private JLabel backgroundLabel;
    private RoundButton loginButton;
    private JButton registerButton;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPanel() {
        setLayout(null);

        backgroundLabel = new JLabel(new ImageIcon("/images/background.jpg"));
        add(backgroundLabel); 
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());

        JLabel titleLabel = new JLabel("Welcome! Begin your diary!");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        titleLabel.setBounds(100, 180, 475, 40);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameLabel.setBounds(145,280,85,25);
        usernameField = new JTextField(15);
        usernameField.setBounds(230,280,120,25);
        
        JLabel passwordLabel = new JLabel("Keyword:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordLabel.setBounds(158,350,72,25);
        passwordField = new JPasswordField(15);
        passwordField.setBounds(230,350,120,25);
        
        loginButton = new RoundButton(" Log in ",25);
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setBounds(185,420,100,27);
        loginButton.setOpaque(false);
        loginButton.setUI(new PressUI(25) {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(new Color(230, 230, 230));
                g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 15, 15);
            }
        });

        registerButton = new JButton("<html><u>Register</u></html>");
        registerButton.setBounds(185,460,100,25);
        
        registerButton.setBorderPainted(false);
        registerButton.setOpaque(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);

        add(titleLabel);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }
}
