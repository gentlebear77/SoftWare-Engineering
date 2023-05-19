package UI;

import javax.sound.sampled.Control;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.io.IOException;

import Control.Module;
import Control.Student;
import Control.*;

public class MainFrame extends JFrame{
    
    private CardLayout cardLayout;
    private JPanel cards;

    Student currentUser = new Student();
    Module currentModule = new Module();


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
        GradePanel gradePanel = new GradePanel(currentUser);
        FunctionPanel functionPanel = new FunctionPanel();
        InclassPanel inclassPanel = new InclassPanel();
        InclassImport inclassImport = new InclassImport();
        InclassImport2 inclassImport2 = new InclassImport2();
        ExtraclassPanel extraclassPanel = new ExtraclassPanel();
        ExtraImport1 extraImport1 = new ExtraImport1();
        ExtraImport2 extraImport2 = new ExtraImport2();
        CampusPanel campusPanel = new CampusPanel();
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
        Representative_Control representative_control = new Representative_Control();
        Total_Control total_control = new Total_Control();
        Volunteer_Control  volunteer_control = new Volunteer_Control();


        loginPanel.getLoginButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(control_initialize.loginCheck(loginPanel.getUsername(),loginPanel.getPassword())==1){
                    currentUser = control_initialize.getCurrentUser();
                    currentUser.setCurrentUser(currentUser);
                    System.out.println(currentUser.toString());
                    cardLayout.show(cards, "gradePanel");
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
                cardLayout.show(cards, "functionPanel");
            }
        });
        gradePanel.getButton2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "functionPanel");
            }
        });
        gradePanel.getButton3().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "functionPanel");
            }
        });
        gradePanel.getButton4().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "functionPanel");
            }
        });
        gradePanel.getButton5().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                if(module_control.ModuleCheck(currentUser.getStudentID()) == 1){
                    currentModule = module_control.getCurrentModule();
                    inclassPanel.Update(currentModule);
                    cardLayout.show(cards, "inclassPanel");
                }
            }
        });
        //Extraclass
        functionPanel.getChoiceButton3().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "extraclassPanel");
            }
        });

        functionPanel.getChoiceButton4().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                //cardLayout.show(cards, "inclassPanel");
            }
        });
        functionPanel.getChoiceButton5().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
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
        	public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "inclassImport");
            }
        });

        inclassPanel.getImportButton2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "inclassImport2");
            }
        });

        inclassImport.getFinishButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "inclassPanel");
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

        extraImport1.getFinishButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "extraclassPanel");
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
                cardLayout.show(cards, "extraclassPanel");
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

        campusImport.getFinishButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "campusPanel");
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
                cardLayout.show(cards, "campusPanel");
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
