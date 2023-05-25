package UI;

import Control.Student;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ExtraclassPanel extends JPanel{

    private JButton backButton;
	private JButton exitButton;
	private JButton importButton1;
    private JButton importButton2;
    private JButton deleteButton1;
    private JButton deleteButton2;
    public JScrollPane panel1;
    public JScrollPane panel2;

    public ExtraclassPanel(Student user) {
        setLayout(null);
        
        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        JLabel titleLabel = new JLabel("Extra-Class Practice");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(70,50,250,40); 

        JLabel subtitle1 = new JLabel("Reseach and Project");
        subtitle1.setFont(new Font("Arial", Font.BOLD, 20));
        subtitle1.setBounds(160,130,220,30); 
        //JPanel panel1 = new JPanel();
        //panel1.setBounds(90,190,340,360);

        panel1 = createProjectsPanel(user);
        panel1.setBounds(90,190,340,360);
        panel1.setBorder(BorderFactory.createEtchedBorder());
        
        JLabel subtitle2 = new JLabel("Achievements");
        subtitle2.setFont(new Font("Arial", Font.BOLD, 20));
        subtitle2.setBounds(620,130,220,30); 
        //JPanel panel2 = new JPanel();
        // panel2.setBounds(520,190,340,360);
        panel2 = createAwardsPanel(user);
        panel2.setBounds(520,190,340,360);
        panel2.setBorder(BorderFactory.createEtchedBorder());
        
        importButton1 = new JButton("Import Project");
        importButton1.setBounds(350,60,130,25);
        
        importButton2 = new JButton("Import Achievements");
        importButton2.setBounds(750,60,180,25);

        deleteButton1=new JButton("Delete the newest project");
        deleteButton1.setBounds(100,570,200,30);

        deleteButton2=new JButton("Delete the newest achievement");
        deleteButton2.setBounds(520,570,200,30);

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


    public static JScrollPane createProjectsPanel(Student user) {
        JPanel projectsPanel = new JPanel();
        projectsPanel.setLayout(new BoxLayout(projectsPanel, BoxLayout.Y_AXIS));
        if(user.getStudentID()!=null){
            for (int i = 0; i < user.projectList.size(); i++) {
                projectsPanel.add(createProject(user.projectList.get(i).getProjectName(), user.projectList.get(i).getDate(), user.projectList.get(i).getContent()));
            }
            //projectsPanel.add(createProject("Project 1", "2022-04-11", "This is a project description."));
            projectsPanel.setPreferredSize(new Dimension(250, 150 * user.projectList.size()));
        }
        JScrollPane scrollPane = new JScrollPane(projectsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    public static JPanel createProject(String projectName, String projectTime, String projectDescription) {
        JPanel projectPanel = new JPanel(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel(projectName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(nameLabel, BorderLayout.WEST);
        JLabel timeLabel = new JLabel(projectTime);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        headerPanel.add(timeLabel, BorderLayout.EAST);

        JTextArea descriptionArea = new JTextArea(projectDescription);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 15));
        projectPanel.add(headerPanel, BorderLayout.NORTH);
        projectPanel.add(descriptionArea, BorderLayout.CENTER);

        return projectPanel;
    }

    public static JScrollPane createAwardsPanel(Student user) {
        System.out.println(user.projectList);
        JPanel awardsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        awardsPanel.setLayout(new BoxLayout(awardsPanel, BoxLayout.Y_AXIS));
        //This i can be set as a variable that indicate the max number of the item.
        //some back code can set the i use an variable max number.
        if(user.getStudentID()!=null){
            for (int i = 0; i < user.achievementList.size(); i++) {
                awardsPanel.add(createAward(user.achievementList.get(i).getAchievementName(), user.achievementList.get(i).getDate()));
            }
            //This 50*max number of item ,Here set as 10.
            awardsPanel.setPreferredSize(new Dimension(200, 50 * user.achievementList.size()));
        }
        JScrollPane scrollPane = new JScrollPane(awardsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    public static JPanel createAward(String awardName, String awardTime) {
        JPanel awardPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        awardPanel.setBackground(Color.WHITE);
        JLabel nameLabel = new JLabel(awardName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        awardPanel.add(nameLabel);

        JLabel timeLabel = new JLabel(awardTime);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        awardPanel.add(timeLabel);
        
        Border border = new LineBorder(Color.LIGHT_GRAY, 1);
        awardPanel.setBorder(border);
        return awardPanel;
    }
}
