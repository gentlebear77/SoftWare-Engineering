package BoundryClass;

import javax.swing.*;
import java.time.LocalDate;

public class Control_check extends JPanel {
    public String check_year(JTextField field){
        if(!field.getText().equals("")){
            try{
                LocalDate date=LocalDate.parse(field.getText());
                if(date.isBefore(LocalDate.of(2100,1,1))&&date.isAfter(LocalDate.of(1999,1,1))){
                    return field.getText();
                }else {
                    //JOptionPane.showMessageDialog(this,date+" might be a wrong date","Warning",JOptionPane.ERROR_MESSAGE);
                    return "";
                }
            }catch (Exception e){
                //JOptionPane.showMessageDialog(this,"yyyy-mm-dd wanted, where yyyy for years, mm for months, dd for days.","Error",JOptionPane.ERROR_MESSAGE);
                return "";
            }

        }else{
            //JOptionPane.showMessageDialog(this,"No year data has been input.","Error",JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }

    public String check_empty(JTextField field){
        if(!field.getText().equals("")){
            return field.getText();
        }else{
            //JOptionPane.showMessageDialog(this,"No data has been input.","Error",JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }

}
