package Control;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONReader;

public class Control_Search {
    public ArrayList<Module> searchModule(Student stu, String searchCondition, String type) {
        ArrayList<Module> result = new ArrayList<Module>();
        String condition = "";
        int i = 0;

        if (type.equals("name")) {
            for (i = 0; i < stu.getModuleList().size(); i++) {
                if (searchCondition.equals(stu.getModuleList().get(i).getModuleName())) {
                    result.add(stu.getModuleList().get(i));
                    break;
                }
            }

        }
        if (type.equals("num")) {
            for (i = 0; i < stu.getModuleList().size(); i++) {
                if (searchCondition.equals(stu.getModuleList().get(i).getModuleNum())) {
                    result.add(stu.getModuleList().get(i));
                    break;
                }
            }
        }
        if (type.equals("grade")) {
            for (i = 0; i < stu.getModuleList().size(); i++) {
                if (Integer.parseInt(searchCondition) == stu.getModuleList().get(i).getGrade()) {
                    result.add(stu.getModuleList().get(i));
                }
            }
        }
        if (type.equals("credit")) {
            for (i = 0; i < stu.getModuleList().size(); i++) {
                if (Double.parseDouble(searchCondition) == stu.getModuleList().get(i).getCredit()) {
                    result.add(stu.getModuleList().get(i));
                }
            }
        }
        if (type.equals("mark")) {
            for (i = 0; i < stu.getModuleList().size(); i++) {
                if (Double.parseDouble(searchCondition) == stu.getModuleList().get(i).getMark()) {
                    result.add(stu.getModuleList().get(i));
                }
            }
        }

        return result;

    }
}
