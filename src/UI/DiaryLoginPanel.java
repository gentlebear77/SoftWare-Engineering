package UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Controller.RegisterLogin;

class DiaryLoginPanel extends JPanel {
	private BufferedImage backgroundImage;
    public DiaryLoginPanel(JFrame mainFrame) {
    	try {
            backgroundImage = ImageIO.read(getClass().getResource("/images/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
        setBackground(Color.LIGHT_GRAY);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST; //left
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Welcome!Begin your diary!");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(titleLabel, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        //gbc.insets = new Insets(10, 0, 10, 0);
        add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
       
        add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Keyword:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        
        add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        
        add(passwordField, gbc);

        JButton loginButton = new JButton(" Log in ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        //loginButton.setBounds(200, 50, 100,40);
        add(loginButton, gbc);
       
      
        //round button
        loginButton.setOpaque(false);
        loginButton.setUI(new RoundButtonUI(20) {
            @Override
            protected void paintButtonPressed(Graphics g, AbstractButton b) {
                g.setColor(new Color(150, 150, 150));
                g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 15, 15);
            }
        });

        loginButton.setBorder(new RoundedBorder(20)); // 20 is the angle of the button

        JButton registerButton = new JButton("Register");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(registerButton, gbc);
        registerButton.setBorderPainted(false);
        registerButton.setOpaque(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Back side code

                mainFrame.setContentPane(new RegisterPanel(mainFrame));
                mainFrame.revalidate();
            }
        });

        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Back side code
                try {
                    if(RegisterLogin.login(usernameField.getText(),passwordField.getText()))
                    // Log in successfully and open the home page
                    mainFrame.setContentPane(new HomePanel(mainFrame));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                mainFrame.revalidate();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}


