package BoundryClass;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

import ControllerClass.*;
import EntityClass.Student;

public class MainFrame extends JFrame{
    
    private CardLayout cardLayout;
    private JPanel cards;

    Student currentUser = new Student();


    public MainFrame() {
        setTitle("Diary Application");
        setSize(975, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Fix the window location
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        int offsetX=(screenSize.width-getWidth())/2;
        int offsetY=(screenSize.height-getHeight())/2;
        setLocation(offsetX, offsetY); 
        setResizable(false);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        /**
         * For UI
         */

        LoginPanel loginPanel = new LoginPanel();
        RegisterPanel registerPanel = new RegisterPanel();
        GradePanel gradePanel = new GradePanel();
        FunctionPanel functionPanel = new FunctionPanel();
        InclassPanel inclassPanel = new InclassPanel();
        InclassImport inclassImport = new InclassImport();
        InclassImport2 inclassImport2 = new InclassImport2();
        ExtraclassPanel extraclassPanel = new ExtraclassPanel(currentUser);
        ExtraImport1 extraImport1 = new ExtraImport1();
        ExtraImport2 extraImport2 = new ExtraImport2();
        CampusPanel campusPanel = new CampusPanel(currentUser);
        CampusImport campusImport = new CampusImport();
        CampusImport2 campusImport2 = new CampusImport2();
        PortfolioPanel portfolioPanel = new PortfolioPanel();
        PersonPanel personPanel = new PersonPanel(currentUser);

        /**
         * For Control
         */
        Control_Initialize control_initialize = new Control_Initialize();
        Module_Control module_control = new Module_Control();
        Project_Control project_control = new Project_Control();
        Achievement_Control achievement_control = new Achievement_Control();
        Representative_Control representative_control = new Representative_Control();
        Total_Control total_control = new Total_Control();
        Volunteer_Control  volunteer_control = new Volunteer_Control();


        loginPanel.getLoginButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(control_initialize.loginCheck(loginPanel.getUsername(),loginPanel.getPassword())==1){
                    currentUser = control_initialize.getCurrentUser();
                    currentUser.setCurrentUser(currentUser);
                    currentUser.moduleList = module_control.Read_ModuleJson(currentUser.getStudentID());
                    currentUser.totalList = total_control.Read_TotalJson(currentUser.getStudentID());
                    currentUser.projectList = project_control.Read_ProjectJson(currentUser.getStudentID());
                    currentUser.achievementList = achievement_control.Read_AchievementJson(currentUser.getStudentID());
                    currentUser.representativeList = representative_control.Read_RepresentativeJson(currentUser.getStudentID());
                    currentUser.volunteerList = volunteer_control.Read_VolunteerJson(currentUser.getStudentID());
                    System.out.println(currentUser.toString()+"!!!");
                    gradePanel.Update(currentUser);
                    cardLayout.show(cards, "gradePanel");
                }else{
                    JOptionPane.showMessageDialog(loginPanel,"Password and username do not match","Login failed",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        loginPanel.getRegisterButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "registerPanel");
            }
        });
        
        registerPanel.getFinishButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(control_initialize.signUp(registerPanel.getUsername(),registerPanel.getPassword(),registerPanel.getMajor(),registerPanel.getRealname(),registerPanel.getGrade())){

                    cardLayout.show(cards, "loginPanel");
                }

            }
        });

        registerPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });
        
        gradePanel.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });
        gradePanel.getButton1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentUser.currentgrade =  "1";

                cardLayout.show(cards, "functionPanel");
            }
        });
        gradePanel.getButton2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(currentUser.getDegree()) >= 2){
                    currentUser.currentgrade =  "2";
                    gradePanel.Update(currentUser);
                    cardLayout.show(cards, "functionPanel");
                }
                else{
                    JOptionPane.showMessageDialog(gradePanel,"No hurry, you will access in the future.","Access Failure",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        gradePanel.getButton3().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(currentUser.getDegree()) >= 3){
                    currentUser.currentgrade =  "3";
                    gradePanel.Update(currentUser);
                    cardLayout.show(cards, "functionPanel");
                }
                else{
                    JOptionPane.showMessageDialog(gradePanel,"No hurry, you will access in the future.","Access Failure",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        gradePanel.getButton4().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(currentUser.getDegree()) >= 4){
                    currentUser.currentgrade =  "4";
                    gradePanel.Update(currentUser);

                    cardLayout.show(cards, "functionPanel");
                }
                else{
                    JOptionPane.showMessageDialog(gradePanel,"No hurry, you will access in the future.","Access Failure",JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        gradePanel.getButton5().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentUser.currentgrade =  "0";
                cardLayout.show(cards, "functionPanel");
            }
        });

        //Personal Panel
        gradePanel.getPersonButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                personPanel.Update(currentUser);
                cardLayout.show(cards, "personPanel");
            }
        });
        //grade choose
        functionPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "gradePanel");
            }
        });

        functionPanel.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });
        // Main Page
        //Portfolio
        functionPanel.getChoiceButton1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "portfolioPanel");
            }
        });
        //Inclass
        functionPanel.getChoiceButton2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                inclassPanel.Update_Score(currentUser);
                inclassPanel.Update_Module(currentUser);
                cardLayout.show(cards, "inclassPanel");

            }
        });
        //Extraclass
        functionPanel.getChoiceButton3().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //extraclassPanel.update(currentUser);
                extraclassPanel.remove(9);
                extraclassPanel.remove(9);
                JScrollPane p1=ExtraclassPanel.createProjectsPanel(currentUser);
                p1.setBounds(90,190,340,360);
                p1.setBorder(BorderFactory.createEtchedBorder());
                extraclassPanel.add(p1);
                JScrollPane p2=ExtraclassPanel.createAwardsPanel(currentUser);
                p2.setBounds(520,190,340,360);
                p2.setBorder(BorderFactory.createEtchedBorder());
                extraclassPanel.add(p2);
                cardLayout.show(cards, "extraclassPanel");
            }
        });
        //导出
        functionPanel.getChoiceButton4().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Control_Im_Export.Export_Module_Excel(currentUser,"src/users/"+currentUser.getStudentID()+"/Modules.xls");
                    JOptionPane.showMessageDialog(functionPanel,"Done! Find at:src/users/"+currentUser.getStudentID()+"Modules.xls","Export",JOptionPane.PLAIN_MESSAGE);
                }
                catch (Exception ex){System.out.println(ex.getMessage());}
                //cardLayout.show(cards, "inclassPanel");
            }
        });
        functionPanel.getChoiceButton5().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campusPanel.remove(9);
                campusPanel.remove(9);
                JScrollPane p1=campusPanel.createRepPanel(currentUser);
                p1.setBounds(90,190,340,360);
                p1.setBorder(BorderFactory.createEtchedBorder());
                campusPanel.add(p1);
                JScrollPane p2=campusPanel.createVolunPanel(currentUser);
                p2.setBounds(520,190,340,360);
                p2.setBorder(BorderFactory.createEtchedBorder());
                campusPanel.add(p2);
                cardLayout.show(cards, "campusPanel");
            }
        });
        
        inclassPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "functionPanel");
            }
        });
        inclassPanel.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        inclassPanel.getImportButton1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {cardLayout.show(cards, "inclassImport");
            }
        });

        inclassPanel.getImportButton2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "inclassImport2");
            }
        });

        inclassPanel.getDeleteButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                control_initialize.newFile(currentUser.getStudentID(), "Module");
                currentUser.moduleList.remove(currentUser.moduleList.size()-1);
                for(int i=0 ; i<currentUser.moduleList.size() ; i++){
                    module_control.writeUserFile(currentUser.getStudentID(),currentUser.moduleList.get(i).getModuleNum(),currentUser.moduleList.get(i).getModuleName(),currentUser.moduleList.get(i).getGrade(),currentUser.moduleList.get(i).getCredit(),currentUser.moduleList.get(i).getMark());
                }
                inclassPanel.Update_Module(currentUser);
                cardLayout.show(cards, "inclassPanel");
            }
        });

        inclassImport.getFinishButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num=inclassImport.getnumberField();
                String name=inclassImport.getnameField();
                double credit=inclassImport.getcreditField();
                double mark=inclassImport.getmarkField();
                if(num.equals("")||name.equals("")||credit<0||mark<0){
                    JOptionPane.showMessageDialog(inclassImport, "Ensure no invalid number and empty field", "Error", JOptionPane.ERROR_MESSAGE);
                    cardLayout.show(cards, "inclassPanel");
                }
                else{
                    module_control.writeUserFile(currentUser.getStudentID(),num,name,inclassImport.getGrade(),credit,mark);
                    currentUser.moduleList = module_control.Read_ModuleJson(currentUser.getStudentID());
                    inclassPanel.Update_Module(currentUser);
                    cardLayout.show(cards, "inclassPanel");}
            }
        });

        inclassImport.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        inclassImport.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "inclassPanel");
            }
        });

        inclassImport2.getFinishButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                total_control.writeUserFile(currentUser.getStudentID(),inclassImport2.getScoreField(),inclassImport2.getScoreField2(),inclassImport2.getGPAField(),inclassImport2.getRankField());
                currentUser.totalList = total_control.Read_TotalJson(currentUser.getStudentID());
                inclassPanel.Update_Score(currentUser);
                cardLayout.show(cards, "inclassPanel");
            }
        });

        inclassImport2.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        inclassImport2.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "inclassPanel");
            }
        });

        extraclassPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "functionPanel");
            }
        });
        extraclassPanel.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        extraclassPanel.getImportButton1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "extraImport1");
            }
        });

        extraclassPanel.getImportButton2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "extraImport2");
            }
        });
        extraclassPanel.getDeleteButton1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                extraclassPanel.remove(9);
                extraclassPanel.remove(9);
                control_initialize.newFile(currentUser.getStudentID(), "Project");
                currentUser.projectList.remove(currentUser.projectList.size()-1);
                for(int i=0;i<currentUser.projectList.size();i++){
                    project_control.writeUserFile(currentUser.getStudentID(),currentUser.projectList.get(i).getProjectName(),currentUser.projectList.get(i).getDate(),currentUser.projectList.get(i).getContent(),currentUser.currentgrade);
                }
                currentUser.projectList = project_control.Read_ProjectJson(currentUser.getStudentID());
                JScrollPane p1=ExtraclassPanel.createProjectsPanel(currentUser);
                p1.setBounds(90,190,340,360);
                p1.setBorder(BorderFactory.createEtchedBorder());
                extraclassPanel.add(p1);
                JScrollPane p2=ExtraclassPanel.createAwardsPanel(currentUser);
                p2.setBounds(520,190,340,360);
                p2.setBorder(BorderFactory.createEtchedBorder());
                extraclassPanel.add(p2);
                extraclassPanel.revalidate();
                extraclassPanel.repaint();
                cardLayout.show(cards,"extraclassPanel");
            }
        });
        extraclassPanel.getDeleteButton2().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                extraclassPanel.remove(9);
                extraclassPanel.remove(9);
                control_initialize.newFile(currentUser.getStudentID(), "Achievement");
                currentUser.achievementList.remove(currentUser.achievementList.size()-1);
                for(int i=0;i<currentUser.achievementList.size();i++){
                    achievement_control.writeUserFile(currentUser.getStudentID(),currentUser.achievementList.get(i).getAchievementName(),currentUser.achievementList.get(i).getDate(),currentUser.currentgrade);
                }
                currentUser.achievementList = achievement_control.Read_AchievementJson(currentUser.getStudentID());
                JScrollPane p1=ExtraclassPanel.createProjectsPanel(currentUser);
                p1.setBounds(90,190,340,360);
                p1.setBorder(BorderFactory.createEtchedBorder());
                extraclassPanel.add(p1);
                JScrollPane p2=ExtraclassPanel.createAwardsPanel(currentUser);
                p2.setBounds(520,190,340,360);
                p2.setBorder(BorderFactory.createEtchedBorder());
                extraclassPanel.add(p2);
                extraclassPanel.revalidate();
                extraclassPanel.repaint();
                cardLayout.show(cards,"extraclassPanel");
            }
        });

        extraImport1.getFinishButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name=extraImport1.getNameField();
                String year=extraImport1.getYearField();
                String cont=extraImport1.getContentField();
                if(name.equals("")||name.equals("")||cont.equals("")){
                    JOptionPane.showMessageDialog(extraImport1,"yyyy-mm-dd wanted, where yyyy for years, mm for months, dd for days.\nEnsure no empty field.","Error",JOptionPane.ERROR_MESSAGE);
                    cardLayout.show(cards, "extraclassPanel");
                }
                else{
                    project_control.writeUserFile(currentUser.getStudentID(),name,year,cont,currentUser.currentgrade);
                    currentUser.projectList = project_control.Read_ProjectJson(currentUser.getStudentID());
                    extraclassPanel.remove(9);
                    extraclassPanel.remove(9);
                    JScrollPane p1=ExtraclassPanel.createProjectsPanel(currentUser);
                    p1.setBounds(90,190,340,360);
                    p1.setBorder(BorderFactory.createEtchedBorder());
                    extraclassPanel.add(p1);
                    JScrollPane p2=ExtraclassPanel.createAwardsPanel(currentUser);
                    p2.setBounds(520,190,340,360);
                    p2.setBorder(BorderFactory.createEtchedBorder());
                    extraclassPanel.add(p2);

                    cardLayout.show(cards, "extraclassPanel");}
            }
        });

        extraImport1.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        extraImport1.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "extraclassPanel");
            }
        });

        extraImport2.getFinishButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name=extraImport2.getNameField();
                String year=extraImport2.getYearField();
                if(name.equals("")||year.equals("")){
                    JOptionPane.showMessageDialog(extraImport1,"yyyy-mm-dd wanted, where yyyy for years, mm for months, dd for days.\nEnsure no empty field.","Error",JOptionPane.ERROR_MESSAGE);
                    cardLayout.show(cards, "extraclassPanel");}
                else {
                    achievement_control.writeUserFile(currentUser.getStudentID(),name,year,currentUser.currentgrade);
                    currentUser.achievementList = achievement_control.Read_AchievementJson(currentUser.getStudentID());
                    extraclassPanel.remove(9);
                    extraclassPanel.remove(9);
                    JScrollPane p1=ExtraclassPanel.createProjectsPanel(currentUser);
                    p1.setBounds(90,190,340,360);
                    p1.setBorder(BorderFactory.createEtchedBorder());
                    extraclassPanel.add(p1);
                    JScrollPane p2=ExtraclassPanel.createAwardsPanel(currentUser);
                    p2.setBounds(520,190,340,360);
                    p2.setBorder(BorderFactory.createEtchedBorder());
                    extraclassPanel.add(p2);

                    cardLayout.show(cards, "extraclassPanel");}
            }
        });

        extraImport2.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        extraImport2.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "extraclassPanel");
            }
        });

        campusPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "functionPanel");
            }
        });
        campusPanel.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        campusPanel.getImportButton1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "campusImport");
            }
        });

        campusPanel.getImportButton2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "campusImport2");
            }
        });

        campusPanel.getDeleteButton1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campusPanel.remove(9);
                campusPanel.remove(9);
                control_initialize.newFile(currentUser.getStudentID(), "Representative");
                currentUser.representativeList.remove(currentUser.representativeList.size()-1);
                for(int i=0;i<currentUser.representativeList.size();i++){
                    representative_control.writeUserFile(currentUser.getStudentID(),currentUser.representativeList.get(i).getRepresentativeName(),currentUser.representativeList.get(i).getDate(),currentUser.currentgrade);
                }
                currentUser.representativeList = representative_control.Read_RepresentativeJson(currentUser.getStudentID());
                JScrollPane p1=campusPanel.createRepPanel(currentUser);
                p1.setBounds(90,190,340,360);
                p1.setBorder(BorderFactory.createEtchedBorder());
                campusPanel.add(p1);
                JScrollPane p2=campusPanel.createVolunPanel(currentUser);
                p2.setBounds(520,190,340,360);
                p2.setBorder(BorderFactory.createEtchedBorder());
                campusPanel.add(p2);
                campusPanel.revalidate();
                campusPanel.repaint();
                cardLayout.show(cards,"campusPanel");
            }
        });

        campusPanel.getDeleteButton2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campusPanel.remove(9);
                campusPanel.remove(9);
                control_initialize.newFile(currentUser.getStudentID(), "Volunteer");
                currentUser.volunteerList.remove(currentUser.volunteerList.size()-1);
                for(int i=0;i<currentUser.volunteerList.size();i++){
                    volunteer_control.writeUserFile(currentUser.getStudentID(),currentUser.volunteerList.get(i).getVolunteerName(),currentUser.volunteerList.get(i).getDate(),currentUser.volunteerList.get(i).getDuration(),currentUser.currentgrade);
                }
                currentUser.volunteerList = volunteer_control.Read_VolunteerJson(currentUser.getStudentID());
                JScrollPane p1=campusPanel.createRepPanel(currentUser);
                p1.setBounds(90,190,340,360);
                p1.setBorder(BorderFactory.createEtchedBorder());
                campusPanel.add(p1);
                JScrollPane p2=campusPanel.createVolunPanel(currentUser);
                p2.setBounds(520,190,340,360);
                p2.setBorder(BorderFactory.createEtchedBorder());
                campusPanel.add(p2);
                campusPanel.revalidate();
                campusPanel.repaint();
                cardLayout.show(cards,"campusPanel");
            }
        });

        campusImport.getFinishButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name=campusImport.getNameField();
                String year=campusImport.getYearField();
                if(name.equals("")||year.equals("")){
                    JOptionPane.showMessageDialog(extraImport1,"yyyy-mm-dd wanted, where yyyy for years, mm for months, dd for days.\nEnsure no empty field.","Error",JOptionPane.ERROR_MESSAGE);
                    cardLayout.show(cards, "campusPanel");
                }else{
                    representative_control.writeUserFile(currentUser.getStudentID(),name,year,currentUser.currentgrade);
                    currentUser.representativeList = representative_control.Read_RepresentativeJson(currentUser.getStudentID());

                    campusPanel.remove(9);
                    campusPanel.remove(9);
                    JScrollPane p1=campusPanel.createRepPanel(currentUser);
                    p1.setBounds(90,190,340,360);
                    p1.setBorder(BorderFactory.createEtchedBorder());
                    campusPanel.add(p1);
                    JScrollPane p2=campusPanel.createVolunPanel(currentUser);
                    p2.setBounds(520,190,340,360);
                    p2.setBorder(BorderFactory.createEtchedBorder());
                    campusPanel.add(p2);
                    cardLayout.show(cards, "campusPanel");}
            }
        });

        campusImport.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        campusImport.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "campusPanel");
            }
        });

        campusImport2.getFinishButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name=campusImport2.getNameField();
                String year=campusImport2.getYearField();
                String dur=campusImport2.getDurationField();
                if(name.equals("")||year.equals("")||dur.equals("")){
                    JOptionPane.showMessageDialog(extraImport1,"yyyy-mm-dd wanted, where yyyy for years, mm for months, dd for days.\nEnsure no empty field.","Error",JOptionPane.ERROR_MESSAGE);
                    cardLayout.show(cards, "campusPanel");}
                else{
                    volunteer_control.writeUserFile(currentUser.getStudentID(),name,year,dur,currentUser.currentgrade);
                    currentUser.volunteerList = volunteer_control.Read_VolunteerJson(currentUser.getStudentID());

                    campusPanel.remove(9);
                    campusPanel.remove(9);
                    JScrollPane p1=campusPanel.createRepPanel(currentUser);
                    p1.setBounds(90,190,340,360);
                    p1.setBorder(BorderFactory.createEtchedBorder());
                    campusPanel.add(p1);
                    JScrollPane p2=campusPanel.createVolunPanel(currentUser);
                    p2.setBounds(520,190,340,360);
                    p2.setBorder(BorderFactory.createEtchedBorder());
                    campusPanel.add(p2);


                    cardLayout.show(cards, "campusPanel");}
            }
        });

        campusImport2.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        campusImport2.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "campusPanel");
            }
        });

        portfolioPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "functionPanel");
            }
        });
        portfolioPanel.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        personPanel.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "loginPanel");
            }
        });

        personPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "gradePanel");
            }
        });

//        comboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JComboBox cb = (JComboBox) e.getSource();
//                String selectedItem = (String) cb.getSelectedItem();
//                cardLayout.show(cards, selectedItem);
//            }
//        });

        cards.add(loginPanel, "loginPanel");
        cards.add(registerPanel, "registerPanel");
        cards.add(gradePanel, "gradePanel");
        cards.add(functionPanel, "functionPanel");
        cards.add(inclassPanel, "inclassPanel");
        cards.add(inclassImport, "inclassImport");
        cards.add(inclassImport2, "inclassImport2");
        cards.add(extraclassPanel, "extraclassPanel");
        cards.add(extraImport1, "extraImport1");
        cards.add(extraImport2, "extraImport2");
        cards.add(campusPanel, "campusPanel");
        cards.add(campusImport, "campusImport");
        cards.add(campusImport2, "campusImport2");
        cards.add(portfolioPanel, "portfolioPanel");
        cards.add(personPanel, "personPanel");

        getContentPane().add(cards);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
