package UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CampusPanel extends JPanel{

    private JButton backButton;
	private JButton exitButton;
	private JButton importButton1;
    private JButton importButton2;

    public CampusPanel() {
        setLayout(null);
        
        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        JLabel titleLabel = new JLabel("Campus life");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(150,50,250,40); 

        JLabel subtitle1 = new JLabel("Representative");
        subtitle1.setFont(new Font("Arial", Font.BOLD, 20));
        subtitle1.setBounds(190,130,220,30); 
        //JPanel panel1 = new JPanel();
        //panel1.setBounds(90,190,340,360);
        JScrollPane panel1 = createRepPanel();
        panel1.setBounds(90,190,340,360);
        panel1.setBorder(BorderFactory.createEtchedBorder());
        
        JLabel subtitle2 = new JLabel("Volunteer Experience");
        subtitle2.setFont(new Font("Arial", Font.BOLD, 20));
        subtitle2.setBounds(590,130,220,30); 
        //JPanel panel2 = new JPanel();
        // panel2.setBounds(520,190,340,360);
        JScrollPane panel2 = createVolunPanel();
        panel2.setBounds(520,190,340,360);
        panel2.setBorder(BorderFactory.createEtchedBorder());
        
        importButton1 = new JButton("Import student work");
        importButton1.setBounds(320,60,160,25);
        
        importButton2 = new JButton("Import volunteer experience");
        importButton2.setBounds(700,60,210,25);

        add(backButton);
        add(exitButton);
        add(titleLabel);
        add(subtitle1);
        add(subtitle2);
        add(panel1);
        add(panel2);
        add(importButton1);
        add(importButton2);
    }

    public JButton getBackButton() {
        return backButton;
    }
    public JButton getExitButton() {
        return exitButton;
    }
	public JButton getImportButton1() {
        return importButton1;
    }
    public JButton getImportButton2() {
        return importButton2;
    }

    private static JScrollPane createRepPanel() {
        JPanel repPanel = new JPanel();
        repPanel.setLayout(new BoxLayout(repPanel, BoxLayout.Y_AXIS));

        for (int i = 1; i <= 10; i++) {
            repPanel.add(createRep("Rep " + i, "2022-04-11"));
        }
        repPanel.setPreferredSize(new Dimension(250, 50 * 10));
        JScrollPane scrollPane = new JScrollPane(repPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private static JPanel createRep(String repName, String repTime) {
        JPanel repPanel = new JPanel(new BorderLayout());
        repPanel.setBackground(Color.WHITE);
        JLabel nameLabel = new JLabel(repName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        repPanel.add(nameLabel, BorderLayout.WEST);

        JLabel timeLabel = new JLabel(repTime);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        repPanel.add(timeLabel, BorderLayout.EAST);
        
        Border border = new LineBorder(Color.LIGHT_GRAY, 1);
        repPanel.setBorder(border);
        return repPanel;

    }

    private static JScrollPane createVolunPanel() {
        JPanel volunPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        volunPanel.setLayout(new BoxLayout(volunPanel, BoxLayout.Y_AXIS));
       
        //This i can be set as a variable that indicate the max number of the item.
        //some back code can set the i use an variable max number.
        for (int i = 1; i <= 10; i++) {
            volunPanel.add(createVolunteer("Volunteer Experence" + i, "2022-04-11","4h"));
        }
        //This 50*max number of item ,Here set as 10.
        volunPanel.setPreferredSize(new Dimension(200, 50 * 10));
        JScrollPane scrollPane = new JScrollPane(volunPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private static JPanel createVolunteer(String volunName, String volunTime,String volunteerDuration) {
        JPanel volunPanel = new JPanel(new BorderLayout());
        volunPanel.setBackground(Color.WHITE);
        JLabel nameLabel = new JLabel(volunName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        volunPanel.add(nameLabel, BorderLayout.WEST);

        JLabel timeLabel = new JLabel(volunTime);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        volunPanel.add(timeLabel, BorderLayout.AFTER_LAST_LINE);
        //volunPanel.add(timeLabel, BorderLayout.NORTH);
        JLabel durationLabel = new JLabel(volunteerDuration);
        durationLabel.setFont(new Font("Arial", Font.BOLD, 14));
        volunPanel.add(durationLabel, BorderLayout.EAST);
        
        Border border = new LineBorder(Color.LIGHT_GRAY, 1);
        volunPanel.setBorder(border);
        return volunPanel;
    }

    
}

