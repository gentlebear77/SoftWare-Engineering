package BoundryClass;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import EntityClass.*;
public class CampusPanel extends JPanel{

    private JButton backButton;
	private JButton exitButton;
	private JButton importButton1;
    private JButton importButton2;
    private JButton deleteButton1;
    private JButton deleteButton2;
    public   JScrollPane panel1;
    public   JScrollPane panel2;
    private BufferedImage bg;

    public CampusPanel(Student user) {
        //background
        try {
            bg = ImageIO.read(getClass().getResource("/images/lifebg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        panel1 = createRepPanel(user);
        panel1.setBounds(90,190,340,360);
        panel1.setBorder(BorderFactory.createEtchedBorder());
        
        JLabel subtitle2 = new JLabel("Volunteer Experience");
        subtitle2.setFont(new Font("Arial", Font.BOLD, 20));
        subtitle2.setBounds(590,130,220,30); 
        //JPanel panel2 = new JPanel();
        // panel2.setBounds(520,190,340,360);
        panel2 = createVolunPanel(user);
        panel2.setBounds(520,190,340,360);
        panel2.setBorder(BorderFactory.createEtchedBorder());
        
        importButton1 = new JButton("Import");  //Import student work
        importButton1.setBounds(130,570,100,25);

        importButton2 = new JButton("Import");  //Import volunteer experience
        importButton2.setBounds(570,570,100,25);

        deleteButton1=new JButton("Delete");  //Delete the newest project
        deleteButton1.setBounds(280,570,100,25);

        deleteButton2=new JButton("Delete");  //Delete the newest achievement
        deleteButton2.setBounds(720,570,100,25);

        add(backButton);
        add(exitButton);
        add(titleLabel);
        add(subtitle1);
        add(subtitle2);

        add(importButton1);
        add(importButton2);
        add(deleteButton1);
        add(deleteButton2);
        add(panel1);
        add(panel2);
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
    public JButton getDeleteButton1(){return deleteButton1;}
    public JButton getDeleteButton2(){return deleteButton2;}

    public static JScrollPane createRepPanel(Student user) {
        JPanel repPanel = new JPanel();
        repPanel.setLayout(new BoxLayout(repPanel, BoxLayout.Y_AXIS));
        int cnt = 0;
       if(user.getStudentID()!=null){

           for (int i = 0; i <user.representativeList.size(); i++) {
               if(user.currentgrade.equals(user.representativeList.get(i).getGrade()) || user.currentgrade=="0"){
                   cnt++;
                   repPanel.add(createRep(user.representativeList.get(i).getRepresentativeName(), user.representativeList.get(i).getDate()));
               }

           }
           System.out.println(user.representativeList.size());
           repPanel.setPreferredSize(new Dimension(250, (50 * cnt)));
        }
        JScrollPane scrollPane = new JScrollPane(repPanel);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    public static JPanel createRep(String repName, String repTime) {
        JPanel repPanel = new JPanel();
        repPanel.setBackground(Color.WHITE);

        repPanel.setLayout(new BoxLayout(repPanel, BoxLayout.LINE_AXIS));

        JLabel nameLabel = new JLabel(repName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        repPanel.add(nameLabel);

        JLabel timeLabel = new JLabel(repTime);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        repPanel.add(Box.createHorizontalGlue());
        repPanel.add(timeLabel);

        Border border = new LineBorder(Color.LIGHT_GRAY, 1);
        repPanel.setBorder(border);

        return repPanel;
    }

    public static JScrollPane createVolunPanel(Student user) {
        JPanel volunPanel = new JPanel(new FlowLayout());
        volunPanel.setLayout(new BoxLayout(volunPanel, BoxLayout.Y_AXIS));
        int cnt = 0;
        //This i can be set as a variable that indicate the max number of the item.
        //some back code can set the i use an variable max number.
        if(user.getStudentID()!=null){
            for (int i = 0; i <user.volunteerList.size(); i++) {
                if(user.currentgrade.equals(user.volunteerList.get(i).getGrade()) || user.currentgrade=="0"){
                    cnt++;
                    volunPanel.add(createVolunteer(user.volunteerList.get(i).getVolunteerName(), user.volunteerList.get(i).getDate(),user.volunteerList.get(i).getDuration()));

                }
            }
            //This 50*max number of item ,Here set as 10.
            volunPanel.setPreferredSize(new Dimension(200, 50 * cnt));
        }
        JScrollPane scrollPane = new JScrollPane(volunPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    public static JPanel createVolunteer(String volunName, String volunTime,String volunteerDuration) {
        JPanel volunPanel = new JPanel();
        volunPanel.setBackground(Color.WHITE);

        volunPanel.setLayout(new BoxLayout(volunPanel, BoxLayout.LINE_AXIS));

        JLabel nameLabel = new JLabel(volunName+"                          "+volunTime);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        volunPanel.add(nameLabel);

      /*  JLabel timeLabel = new JLabel(volunTime);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        volunPanel.add(Box.createHorizontalStrut(100));
        volunPanel.add(timeLabel);*/

        //volunPanel.add(timeLabel, BorderLayout.NORTH);
        JLabel durationLabel = new JLabel(volunteerDuration);
        durationLabel.setFont(new Font("Arial", Font.BOLD, 14));
        volunPanel.add(Box.createHorizontalGlue());
        volunPanel.add(durationLabel);

        Border border = new LineBorder(Color.LIGHT_GRAY, 1);
        volunPanel.setBorder(border);

        return volunPanel;

    }
    //background
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw image
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }

    
}

