package UI;

import Control.Module;
import Control.Student;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InclassPanel extends JPanel{
	
	private JButton backButton;
	private JButton exitButton;
	private JButton importButton1;
    private JButton importButton2;
//    public JComboBox<String> comboBox;
    String[] columnNames1 = {"Number", "Module", "Grade", "Credit", "Mark"};
    TablePanel moduletable = new TablePanel(columnNames1);

    String[] columnNames2 = {"Total"};
    TablePanel scoretable = new TablePanel(columnNames2);


	public InclassPanel() {
		setLayout(null);

//        comboBox = new JComboBox<>();
//        comboBox.addItem("选项 1");
//        comboBox.addItem("选项 2");
//        comboBox.addItem("选项 3");
//
//        comboBox.setBounds(200,0,70,30);
//        add(comboBox);

        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        JLabel titleLabel = new JLabel("In-Class Learning");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setBounds(70,50,250,40); 
        
        importButton1 = new JButton("Import Module");
        importButton1.setBounds(330,60,150,25);
        
        importButton2 = new JButton("Import Total Score");
        importButton2.setBounds(750,60,150,25);

        //String[] columnNames1 = {"Number", "Module", "Grade", "Credit", "Mark"};
        //TablePanel moduletable = new TablePanel(columnNames1);
        moduletable.setBorder(new EmptyBorder(5, 5, 5, 5));

        moduletable.setBounds(50,110,600,450);
        //example data
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        moduletable.addRow(new String[]{"QM001", "Management", "2", "3", "87"});
        
        //String[] columnNames2 = {"Total"};
        //TablePanel scoretable = new TablePanel(columnNames2);
        scoretable.setBorder(new EmptyBorder(5, 5, 5, 5));
        scoretable.setBounds(680,110,230,450);
        scoretable.addRow(new String[]{"Average Score: 89"});
        scoretable.addRow(new String[]{"Average Score of Postgraduate: 89"});
        scoretable.addRow(new String[]{"GPA: 3.74/4"});
        scoretable.addRow(new String[]{"Rank: 17/312"});
        
        add(backButton);
        add(exitButton);
        add(titleLabel);
        add(importButton1);
        add(importButton2);
        add(moduletable);
        add(scoretable);

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

    public void Update (Module currentModule) {

        moduletable.addRow(new String[]{"BUPT001", "Math", "1", "4", "96"});
        scoretable.addRow(new String[]{"Average Score: 89"});



    }
}
