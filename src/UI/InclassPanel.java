package UI;

import Control.Module;
import Control.Student;
import Control.Total;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InclassPanel extends JPanel{

    private JButton backButton;
    private JButton exitButton;
    private JButton importButton1;
    private JButton importButton2;
    private JButton deleteButton;
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

        deleteButton=new JButton("Delete the newest record");
        deleteButton.setBounds(330,570,180,30);

        moduletable.setBorder(new EmptyBorder(5, 5, 5, 5));
        moduletable.setBounds(50,110,600,450);

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
        add(deleteButton);

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
    public JButton getDeleteButton(){return deleteButton;}

    public void Update_Module (Student user) {
        double sum=0.0;
        double wSum=0.0;
        double GSum=0.0;
        double creditSum=0.0;
        try{
            for(int i = 0;i <= user.moduleList.size();i++){
                moduletable.removeRow(0);
            }
        }catch (Exception e){System.out.println(e.getMessage());}
        if(user.getStudentID()!=null) {

            for (int i = 0; i < user.moduleList.size(); i++) {

                System.out.println(i+":"+user.moduleList.get(i).getMark());
                sum=sum+user.moduleList.get(i).getMark();
                wSum=wSum+user.moduleList.get(i).getMark()*user.moduleList.get(i).getCredit();
                if(user.moduleList.get(i).getMark()<100&&user.moduleList.get(i).getMark()>=60){
                GSum=GSum+(4-(3*Math.pow(100-user.moduleList.get(i).getMark(),2)/1600))*user.moduleList.get(i).getCredit();
                } else if (user.moduleList.get(i).getMark()>=100) {
                    GSum=GSum+4*user.moduleList.get(i).getCredit();
                } else if(user.moduleList.get(i).getMark()==60){
                    GSum=GSum+1*user.moduleList.get(i).getCredit();
                } else{;}
                creditSum=creditSum+user.moduleList.get(i).getCredit();


                moduletable.addRow(new String[]{user.moduleList.get(i).getModuleNum(), user.moduleList.get(i).getModuleName(), user.moduleList.get(i).getGrade() + "", user.moduleList.get(i).getCredit() + "", user.moduleList.get(i).getMark() + ""});
            }
            Total preTotal=user.totalList.get(user.totalList.size()-1);
            user.totalList.remove(user.totalList.size()-1);
            user.totalList.add(new Total(sum/user.moduleList.size(),wSum/creditSum,String.format("%.1f",GSum/creditSum)+"/4.0",preTotal.getRank()));
            this.Update_Score(user);
        }
    }

    public void Update_Score (Student user) {
        try{
            for(int i = 0;i <4;i++){
                scoretable.removeRow(0);
            }
        }catch (Exception e){System.out.println(e.getMessage()+"?");}
        if(user.getStudentID()!=null&&user.totalList.size()!=0) {
            Total t=user.totalList.get(user.totalList.size()-1);
            scoretable.addRow(new String[]{"Average Score: "+String.format("%.2f",t.getAverageScore())});
            scoretable.addRow(new String[]{"Average Score of Postgraduate: "+String.format("%.2f",t.getAveragePostgraduate())});
            scoretable.addRow(new String[]{"GPA: "+t.getGPA()});
            scoretable.addRow(new String[]{"Rank: "+t.getRank()});
        }
    }
}
